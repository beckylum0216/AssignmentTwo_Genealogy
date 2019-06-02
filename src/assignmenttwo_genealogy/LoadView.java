/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;


/**
 *
 * @author becky
 */
public class LoadView implements EventHandler<ActionEvent>{
    
    private TextField inputField;
    private StackPane loadPane;
    private StackPane parentPane;
    private VBox vMenu;
    
    /**
     * <p>Constructor for the loading screen 
     * @param targetPane 
     */
    LoadView(StackPane targetPane)
    {
        
        this.parentPane = targetPane;
        loadPane = new StackPane();
        VBox loadBox = SetVBox();
        loadPane.maxWidthProperty().bind(this.parentPane.widthProperty().multiply(0.5));
        this.loadPane.getChildren().add(loadBox);
    }
    
    /**
     * <p>Gets the load screen </p>
     * @return loadPane the load subpane
     */
    public StackPane GetLoadPane()
    {
        return this.loadPane;
    }
    
    /**
     * <p> The subpane for the loading screen </p>
     * @return vMenu a simple vertical menu
     */
    private VBox SetVBox()
    {
        vMenu = new VBox();
        vMenu.setId("loadVMenu");
        Insets newInset = new Insets(10,10,10,10);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.TOP_CENTER);
        vMenu.setPadding(newInset);
        
        Label inputLabel = new Label("Path to File:");
        inputField = new TextField("src/assignmenttwo_genealogy/FamilyMembers.dat");
        
        Button chooseButton = new Button("Select File");
        chooseButton.setId("loadFileChooser");
        chooseButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        chooseButton.setOnAction(click->this.handle(click));
        
        Button inputButton = new Button("Load File");
        inputButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        inputButton.setOnAction(click->this.handle(click));
        vMenu.getChildren().addAll(inputLabel, inputField, chooseButton, inputButton);
        
        
        return vMenu;
        
    }
    
    /**
     * <p> Event Handler for the load button </p> 
     * @param event the click button event
     */
    @Override
    public void handle(ActionEvent event) 
    {
        Button saveButton = (Button) event.getSource();
        if(saveButton.getId() == "loadFileChooser")
        {
            FileChooser newChooser = new FileChooser();
            newChooser.setInitialDirectory(new File("src/assignmenttwo_genealogy"));
            newChooser.setInitialFileName("FamilyMembers.dat");
            File selectedFile = newChooser.showOpenDialog(this.loadPane.getScene().getWindow());
            inputField.setText(selectedFile.getPath().toString());
        }
        else
        {
            String filePath = this.inputField.getText();

            try
            {
                FileInputStream inputFile = new FileInputStream(filePath);
                ObjectInputStream inputObject = new ObjectInputStream(inputFile);

                ApplicationController.GetNewInstance().SetTreeDB((ChildDatabase) inputObject.readObject());

                inputFile.close();
                inputObject.close();

                System.out.println("TreeDB deserialised!!!");

            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            int size = ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().size();
            Label confirmationLabel = new Label("Database size: " + size);
            vMenu.getChildren().add(confirmationLabel);
        }
            
            
        
    }
    
    
}
