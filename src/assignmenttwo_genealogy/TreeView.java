/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class TreeView implements EventHandler<MouseEvent> {
    
    
    ArrayList<LeafView> activeView;
    TreeController treeHandler;
    ArrayList<TextField> inputFields;
    Nodi currentRecord;
    
    /**
     * <p>Default constructor for creating the tree menu </p>
     */
    public TreeView()
    {
        
        this.activeView = new ArrayList<>();
    }
    
    /**
     * <p> Mutator to set the position of the labels </p>
     * @return newPane the subpane for the tree view
     */
    public Pane SetTreePane()
    {
        treeHandler = new TreeController();
        double labelWidth = 100.0;
        double labelMargin = 20.0;
        double labelHeight = 20.0;
        
        GridPane parentPane = new GridPane();
        parentPane.setHgap(10);
        parentPane.setGridLinesVisible(false);
        int parentColumns = 2;
        for(int ii = 0; ii < parentColumns; ii += 1)
        {
            ColumnConstraints newColumn = new ColumnConstraints();
            newColumn.setPercentWidth(100.0/parentColumns);
            parentPane.getColumnConstraints().add(newColumn);
        }
        
        
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
        
        inputFields = new ArrayList<>();
        for(int ii = 0; ii < tempLabels.size(); ii += 1 )
        {
            Label myLabel = new Label(tempLabels.get(ii));
            TextField tempFields = new TextField();
            tempFields.setEditable(false);
            inputFields.add(tempFields);
            newPane.add(myLabel, 0, ii);
            newPane.add(inputFields.get(ii), 1, ii);
        }
        
        
        
        Pane subPane = new Pane();
        subPane.setId("treePane");
        this.activeView = treeHandler.GetTreeList();
        
        System.out.println("activeview size: " + this.activeView.size());
        
        // add nodes
        for(int ii = 0; ii < this.activeView.size(); ii += 1)
        {
            if(!this.activeView.get(ii).GetNodeID().equals("root001"))
            {
//                this.activeView.get(ii).GetLeafView().layoutXProperty()
//                                .bind(newPane.widthProperty()
//                                .subtract(this.activeView.get(ii)
//                                .GetLeafView().widthProperty()).divide(2));
                

                this.activeView.get(ii).GetLeafView().setTranslateX((double)this.activeView.get(ii).GetLeafPosition().GetX() * (labelWidth + labelMargin));
                this.activeView.get(ii).GetLeafView().setTranslateY((double)this.activeView.get(ii).GetLeafPosition().GetY() * (labelHeight + labelMargin));
                this.activeView.get(ii).GetLeafView().setId(this.activeView.get(ii).GetNodeID());
                this.activeView.get(ii).GetLeafView().setOnMouseClicked(click->handle(click));
                subPane.getChildren().add(this.activeView.get(ii).GetLeafView());
            }
        }
        
        parentPane.add(subPane, 0, 0);
        parentPane.add(newPane, 1, 0);
        
        return parentPane;
    }

    @Override
    public void handle(MouseEvent event) 
    {
        System.out.println("label id:" + ((Label)event.getSource()).getId());
        System.out.println("db ID:" + ApplicationController.GetNewInstance().GetTreeDB().FindNode(((Label)event.getSource()).getId()));
        
        currentRecord = ApplicationController.GetNewInstance().GetTreeDB().FindNode(((Label)event.getSource()).getId());
        inputFields.get(0).setText(currentRecord.GetPersonID());
        inputFields.get(1).setText(currentRecord.GetFirstName());
        inputFields.get(2).setText(currentRecord.GetLastNameBirth());
        inputFields.get(3).setText(currentRecord.GetLastNameMarraige());
        inputFields.get(4).setText(currentRecord.GetPersonGender());
        inputFields.get(5).setText(currentRecord.GetPersonAddress().street);
        inputFields.get(6).setText(currentRecord.GetPersonAddress().country);
        inputFields.get(7).setText(currentRecord.GetPersonAddress().state);
        inputFields.get(8).setText(String.valueOf(currentRecord.GetPersonAddress().postcode));
        inputFields.get(9).setText(currentRecord.GetPersonBlurb());
        inputFields.get(10).setText(currentRecord.GetParentOne());
        inputFields.get(11).setText(currentRecord.GetParentTwo());
        inputFields.get(12).setText(currentRecord.GetPersonSpouse());
    }
    
}
