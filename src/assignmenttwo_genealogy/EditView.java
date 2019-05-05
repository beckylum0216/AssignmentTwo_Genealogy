/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class EditView 
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
        
        EditController editHandle = new EditController();
        Button editButton = new Button("Edit");
        editButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        
        editButton.setOnAction(click ->editHandle.handle(click));
        newPane.add(editButton, 1, 14, 2, 1);
        
        GridPane subPane = new GridPane();
        subPane.setHgap(10);
        subPane.setGridLinesVisible(false);
        int numberOfSubColumns = 2;
        for(int ii = 0; ii < numberOfColumns; ii += 1)
        {
            ColumnConstraints newColumn = new ColumnConstraints();
            newColumn.setPercentWidth(100.0/numberOfSubColumns);
            subPane.getColumnConstraints().add(newColumn);
        }
        
        
        Button previousButton = new Button("Previous");
        previousButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        previousButton.setOnAction(click ->editHandle.handle(click));
        
        Button nextButton = new Button("Next");
        nextButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        nextButton.setOnAction(click ->editHandle.handle(click));
        
        subPane.add(previousButton, 0, 0);
        subPane.add(nextButton, 1, 0);
        
        
        newPane.add(subPane, 1, 15, 2, 1);
        
        return newPane;
    }
    
    
    
    
}
