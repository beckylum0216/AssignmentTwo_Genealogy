/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class EditView implements EventHandler<ActionEvent>
{
    
    private ListView<String> newList;
    private int numOfFields = 13;
    private TextField[] inputFields = new TextField[numOfFields];
    private EditMouseHandler mouseHandle;
    private StackPane parentPane;
    
    /**
     * <p> Default constructor to the EditView</P> 
     */
    public EditView(StackPane inputPane)
    {
         this.parentPane = inputPane;
    }
     
    /**
     * <p> Mutator for creation of the edit pane</P>
     * @return newPane the view with the child nodes for the view
     */
    public GridPane SetEditPane()
    {
        
        GridPane newPane = new GridPane();
        newPane.setId("EditPane");
        ScrollPane scrollSubPane = new ScrollPane();
        newList = new ListView();
        newList.getItems().addAll(ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().keySet());
        scrollSubPane.setContent(newList);
        scrollSubPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollSubPane.setFitToHeight(true);
        scrollSubPane.setFitToWidth(true);
        newPane.add(scrollSubPane, 0, 0, 1,15);
        
        newPane.setHgap(10);
        newPane.setGridLinesVisible(false);
        int numberOfColumns = 3;
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
            inputFields[ii] = new TextField(); 
            newPane.add(myLabel, 1, ii);
            newPane.add(inputFields[ii], 2, ii);
        }
        
        mouseHandle = new EditMouseHandler(this.newList, this.inputFields);
        newList.setOnMouseClicked(click ->mouseHandle.handle(click));
        
        Button editButton = new Button("Edit");
        editButton.setId("editButton");
        editButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        editButton.setOnAction(click ->handle(click));
        newPane.add(editButton, 2, 14, 1, 1);
        
        GridPane subPane = new GridPane();
        ColumnConstraints columnOne = new ColumnConstraints();
        columnOne.setPercentWidth(50);
        subPane.getColumnConstraints().add(columnOne);
        ColumnConstraints columnTwo = new ColumnConstraints();
        columnTwo.setPercentWidth(50);
        subPane.getColumnConstraints().add(columnTwo);
        
//        Button fwdButton = new Button(">>");
//        Button bwdButton = new Button("<<");
//        fwdButton.setOnAction(click ->handle(click));
//        bwdButton.setOnAction(click ->handle(click));
//        fwdButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        bwdButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //subPane.add(bwdButton, 0,1);
        //subPane.add(fwdButton, 1,1);
        
        newPane.add(subPane, 2,15);
        
        return newPane;
    }
    
    
    /**
     * <p> Event Handler for the edit button. </P>
     * @param event buttons event
     */
    @Override
    public void handle(ActionEvent event) {
        
        Nodi tempNode = mouseHandle.GetCurrentRecord();
        
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
        
        Alert inputAlert = new Alert(Alert.AlertType.INFORMATION);
        inputAlert.setTitle("Input Confirmation");
        inputAlert.setContentText("Your record has been saved. Press edit to edit another record");
        inputAlert.show();
        
        this.parentPane.getChildren().clear();
        ApplicationView initView = new ApplicationView();
        StackPane tempPane = initView.GetNewPane();
        
        this.parentPane.getChildren().add(tempPane);
    }
    
}
