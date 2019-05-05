/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

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
public class LoadView {
    
    public void SetLoadView()
    {
        StackPane basePane = new StackPane();
        
        
        
    }
    
    private VBox SetVBox()
    {
        VBox vMenu = new VBox();
        Insets newInset = new Insets(10,10,10,10);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.TOP_CENTER);
        vMenu.setPadding(newInset);
        
        Label inputLabel = new Label("Path to File:");
        TextField inputField = new TextField("src/assignmenttwo_genealogy/FamilyMembers.csv");
        Button inputButton = new Button("Load File");
        
        vMenu.getChildren().addAll(inputLabel, inputField, inputButton);
        
        
        return vMenu;
        
    }
    
    
}
