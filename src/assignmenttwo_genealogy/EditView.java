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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class EditView implements EventHandler<ActionEvent>
{
    
    
    public EditView()
    {
        
    }
            
    public GridPane SetEditPane()
    {
        
        int numOfFields = 13;
        TextField[] inputFields = new TextField[numOfFields];
        
        
        GridPane newPane = new GridPane();
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
        tempLabels.add("Parent 1:");
        tempLabels.add("Parent 2:");
        tempLabels.add("Spouse:");
        
        for(int ii = 0; ii < numOfFields; ii += 1 )
        {
            Label myLabel = new Label(tempLabels.get(ii));
            inputFields[ii] = new TextField(); 
            
            newPane.add(myLabel, 0, ii);
            newPane.add(inputFields[ii], 1, ii);
        }
        
        Button editButton = new Button("Edit");
        editButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        editButton.setOnAction(click ->handle(click));
        newPane.add(editButton, 1, 14, 2, 1);
        
        
        return newPane;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Button inputButton = (Button) event.getSource();
       
        if (inputButton.getText().equals("Edit"))
        {
            System.out.println("Edit");
            
        }
        else if(inputButton.getText().equals("Previous"))
        {
            System.out.println("Select previous");
        }
        else if(inputButton.getText().equals("Next"))
        {
            System.out.println("Select Next");
        }
    }
    
    
    
}
