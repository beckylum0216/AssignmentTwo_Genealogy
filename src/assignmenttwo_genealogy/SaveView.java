/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
public class SaveView implements EventHandler<ActionEvent>{
    
    private TextField inputField;
    private StackPane loadPane;
    private StackPane parentPane;
    
    /**
     * <p>Constructor for the  save menu</p>
     * @param targetPane save subpane
     */
    SaveView(StackPane targetPane)
    {
        
        this.parentPane = targetPane;
        loadPane = new StackPane();
        loadPane.setId("savePane");
        
        
        VBox loadBox = SetVBox();
        loadPane.maxWidthProperty().bind(this.parentPane.widthProperty().multiply(0.5));
        this.loadPane.getChildren().add(loadBox);
    }
    
    /**
     * <p> Accessor to the load subpane</p>
     * @return loadPane
     */
    public StackPane GetLoadPane()
    {
        return this.loadPane;
    }
    
    /**
     * <p>function to create subpane menu </p>
     * @return vMenu the subpane menu
     */
    private VBox SetVBox()
    {
        VBox vMenu = new VBox();
        Insets newInset = new Insets(10,10,10,10);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.TOP_CENTER);
        vMenu.setPadding(newInset);
        
        Label inputLabel = new Label("Path to File:");
        inputField = new TextField("src/assignmenttwo_genealogy/FamilyMembers.dat");
        Button chooseButton = new Button("Select File");
        chooseButton.setId("saveFileChooser");
        chooseButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        chooseButton.setOnAction(click->this.handle(click));
        Button inputButton = new Button("Save File");
        inputButton.setId("inputButton");
        inputButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        inputButton.setOnAction(click->this.handle(click));
        vMenu.getChildren().addAll(inputLabel, inputField, chooseButton,inputButton);
        
        
        return vMenu;
        
    }
    
    /**
     * <p>Event handler for the save file button </p>
     * @param event click event
     */
    @Override
    public void handle(ActionEvent event) 
    {
        Button saveButton = (Button) event.getSource();
        if(saveButton.getId() == "saveFileChooser")
        {
            DirectoryChooser newChooser = new DirectoryChooser();
            newChooser.setInitialDirectory(new File("src/assignmenttwo_genealogy"));
            File selectedFile = newChooser.showDialog(this.loadPane.getScene().getWindow());
            inputField.setText(selectedFile.getPath().toString() + "/FamilyTree.dat");
        }
        else
        {
            String filePath = this.inputField.getText();
        
            try
            {
                FileOutputStream outputFile = new FileOutputStream(filePath);
                ObjectOutputStream outputObject  = new ObjectOutputStream(outputFile);

                outputObject.writeObject(ApplicationController.GetNewInstance().GetTreeDB());
                outputObject.close();
                outputFile.close();

                System.out.println("Serialisation run successful!!!");

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        
        
        
        
        
    }
    
    
}
