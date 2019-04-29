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
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author becky
 */
public class MenuController implements EventHandler<ActionEvent> {
    
    GridPane menuPane;
    StackPane subPane;
    TreeManager familyTree;
    ArrayList<Button> menuButtons;
    
    MenuController()
    {
        this.familyTree = new TreeManager();
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
            InputView inputForm = new InputView(familyTree);
            subPane.getChildren().clear();
            subPane.getChildren().add(inputForm.SetInputPane());
            menuPane.getChildren().remove(subPane);
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
            EditView editForm = new EditView(familyTree);
            
        }
        else if(inputButton.getId().equals(menuButtons.get(3).getId()))
        {
            TreeView treeForm = new TreeView(familyTree);
            subPane.getChildren().clear();
            subPane.getChildren().add(treeForm.SetTreePane());
            menuPane.getChildren().remove(subPane);
            menuPane.add(subPane, 1, 0);
        }
        
    }
    
}
