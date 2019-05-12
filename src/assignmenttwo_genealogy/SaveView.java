/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

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


/**
 *
 * @author becky
 */
public class SaveView implements EventHandler<ActionEvent>{
    
    private TextField inputField;
    private StackPane loadPane;
    private StackPane parentPane;
    
    SaveView(StackPane targetPane)
    {
        
        this.parentPane = targetPane;
        loadPane = new StackPane();
        VBox loadBox = SetVBox();
        loadPane.maxWidthProperty().bind(this.parentPane.widthProperty().multiply(0.5));
        this.loadPane.getChildren().add(loadBox);
    }
    
    public StackPane GetLoadPane()
    {
        return this.loadPane;
    }
    
    private VBox SetVBox()
    {
        VBox vMenu = new VBox();
        Insets newInset = new Insets(10,10,10,10);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.TOP_CENTER);
        vMenu.setPadding(newInset);
        
        Label inputLabel = new Label("Path to File:");
        inputField = new TextField("src/assignmenttwo_genealogy/FamilyMembers.dat");
        Button inputButton = new Button("Load File");
        inputButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        inputButton.setOnAction(click->this.handle(click));
        vMenu.getChildren().addAll(inputLabel, inputField, inputButton);
        
        
        return vMenu;
        
    }
    
    @Override
    public void handle(ActionEvent event) 
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
