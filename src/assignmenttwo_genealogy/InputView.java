/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class InputView implements EventHandler<ActionEvent>
{
    private int numOfFields = 13;
    private TextField[] inputFields = new TextField[numOfFields];
    private StackPane parentPane;
    
    /**
     * <p>Default constructor for the input view</p>
     */
    InputView(StackPane inputPane)
    {
        this.parentPane = inputPane;
    }
    
    /**
     * <p>Function that creates the pane for nod entry </p>
     * @return newPane the created pane with child elements
     */
    public GridPane SetInputPane()
    {
        
        GridPane newPane = new GridPane();
        newPane.setId("inputNewPane");
        newPane.setHgap(10);
        newPane.setGridLinesVisible(false);
        int numberOfColumns = 2;
        for(int ii = 0; ii < numberOfColumns; ii += 1)
        {
            ColumnConstraints newColumn = new ColumnConstraints();
            newColumn.setPercentWidth(100.0/numberOfColumns);
            newPane.getColumnConstraints().add(newColumn);
        }
        
        ArrayList <String> tempLabels = new ArrayList<>();
        tempLabels.add("Node ID:");
        tempLabels.add("First Name:");
        tempLabels.add("Last Name:");
        tempLabels.add("Married Last Name:");
        tempLabels.add("Gender:");
        tempLabels.add("Street Address:");
        tempLabels.add("Country:");
        tempLabels.add("State:");
        tempLabels.add("Postcode:");
        tempLabels.add("Blurb:");
        tempLabels.add("Primary Parent:");
        tempLabels.add("Other Parent:");
        tempLabels.add("Spouse:");
        
        for(int ii = 0; ii < numOfFields; ii += 1 )
        {
            Label myLabel = new Label(tempLabels.get(ii));
            myLabel.setTextAlignment(TextAlignment.RIGHT);
            //myLabel.setBackground(new Background(new BackgroundFill(Color.web("92E4F0"), CornerRadii.EMPTY, Insets.EMPTY)));
            inputFields[ii] = new TextField(); 
            inputFields[ii].setId(tempLabels.get(ii));
            //inputFields[ii].prefWidthProperty().bind(newPane.widthProperty().multiply(0.8));
            newPane.add(myLabel, 0, ii);
            newPane.add(inputFields[ii], 1, ii);
        }
        
        Button submitButton = new Button("Submit");
        submitButton.setId("inputSubmit");
        submitButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        submitButton.setOnAction(click ->handle(click));
        newPane.add(submitButton, 1, 14, 2, 1);
        
        return newPane;
    }
    
    /**
     * <p>Event handler for the submit button</p>
     */
    @Override
    public void handle(ActionEvent event) 
    {
        
        if(inputFields[8].getText().matches("[0-9]+"))
        {
            Nodi tempNode = new Nodi();
            tempNode.SetPersonID(inputFields[0].getText());
            tempNode.SetFirstName(inputFields[1].getText());
            tempNode.SetLastNameBirth(inputFields[2].getText());
            tempNode.SetLastNameMarraige(inputFields[3].getText());
            tempNode.SetPersonGender(inputFields[4].getText());
            tempNode.GetPersonAddress().street = inputFields[5].getText();
            tempNode.GetPersonAddress().country = inputFields[6].getText();
            tempNode.GetPersonAddress().state = inputFields[7].getText();
            tempNode.GetPersonAddress().postcode = Integer.parseInt(inputFields[8].getText());
            tempNode.SetPersonBlurb(inputFields[9].getText());
            tempNode.SetParentOne(inputFields[10].getText());
            tempNode.SetParentTwo(inputFields[11].getText());
            tempNode.SetPersonSpouse(inputFields[12].getText());
            ApplicationController.GetNewInstance().GetTreeDB().AddNode(tempNode);
            ApplicationController.GetNewInstance().GetTreeDB().FindNode(tempNode).PrintNode();

            Alert inputAlert = new Alert(AlertType.INFORMATION);
            inputAlert.setTitle("Input Confirmation");
            inputAlert.setContentText("Your record has been saved. Press new to add new record");
            inputAlert.show();

            this.parentPane.getChildren().clear();
            ApplicationView initView = new ApplicationView();
            StackPane tempPane = initView.GetNewPane();
            this.parentPane.getChildren().add(tempPane);
        }
        else
        {
            Alert inputAlert = new Alert(AlertType.INFORMATION);
            inputAlert.setTitle("Number Validation");
            inputAlert.setContentText("You have not entered an Australian postcode. Please enter a 4 digit postcode");
            inputAlert.show();
        }
        
        
        
    }
    
    
}
