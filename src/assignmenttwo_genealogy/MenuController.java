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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author becky
 */
public class MenuController implements EventHandler<ActionEvent> {
    
    Scene menuScene;
    GridPane menuPane;
    StackPane subPane;
    
    ArrayList<Button> menuButtons;
    
    MenuController(Scene inputScene, GridPane inputPane)
    {
        this.menuScene = inputScene;
        this.menuPane = inputPane;
        this.menuButtons = new ArrayList<>();
        this.subPane = new StackPane();
    }
    
    public void SetMenuPane(GridPane inputPane)
    {
        this.menuPane = inputPane;
    }
    
    public void AddMenuButtons(Button inputButton)
    {
        menuButtons.add(inputButton);
    }
    

    @Override
    public void handle(ActionEvent event) 
    {
        Button inputButton = (Button) event.getSource();
        if (inputButton.getId().equals(menuButtons.get(0).getId()))
        {
            InputView inputForm = new InputView();
            menuPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(inputForm.SetInputPane());
            //subPane.setStyle("-fx-background-color: blue;");
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.7));
            menuPane.add(subPane, 1, 0);
            
        }
        else if(inputButton.getId().equals(menuButtons.get(1).getId()))
        {
            
        }
        else if(inputButton.getId().equals(menuButtons.get(2).getId()))
        {
            
        
        
        
        }
        else if(inputButton.getId().equals(menuButtons.get(3).getId()))
        {
            EditView editForm = new EditView();
            
        }
        else if(inputButton.getId().equals(menuButtons.get(4).getId()))
        {
            TreeView treeForm = new TreeView();
            menuPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(treeForm.SetTreePane());
            //subPane.setStyle("-fx-background-color: green;");
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.7));
            menuPane.add(subPane, 1, 0);
            
        }
        
    }
    
}
