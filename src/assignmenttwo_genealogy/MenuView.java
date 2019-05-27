/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.lang.reflect.Method;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class MenuView extends Application implements EventHandler<ActionEvent> {
    
    GridPane newPane;
    StackPane subPane;
    String[] bText = {"New", "Load", "Save", "Edit", "View"};
    Button[] menuButtons = new Button[bText.length];
    Scene menuScene;
   
    
    @Override
    public void init()
    {
        this.subPane = new StackPane();
        this.newPane = new GridPane();
        this.menuScene = new Scene(newPane, 1280, 1024);
    }
    
    //https://stackoverflow.com/questions/30679025/graph-visualisation-like-yfiles-in-javafx
    @Override
    public void start(Stage inputStage)
    {
        
        
        this.SetGridPane();
        
        inputStage.setScene(this.menuScene);
        inputStage.setMaximized(true);
        inputStage.show();
       
    }
    
    private VBox SetVBox()
    {
        VBox vMenu = new VBox();
        Insets newInset = new Insets(10,10,10,10);
        vMenu.setSpacing(10);
        vMenu.setAlignment(Pos.TOP_CENTER);
        vMenu.setPadding(newInset);
        
        for(int ii = 0; ii < bText.length; ii += 1)
        {
            menuButtons[ii] = new Button(bText[ii]);
            menuButtons[ii].setId(bText[ii]);
            menuButtons[ii].setMinHeight(100);
            menuButtons[ii].setMaxWidth(Double.MAX_VALUE);
            menuButtons[ii].setOnAction(click->handle(click));
            vMenu.getChildren().add(menuButtons[ii]);
            
        }
        
        //vMenu.setStyle("-fx-background-color: white;");
        vMenu.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.4));
        return vMenu;
        
    }
    
    
    private void SetGridPane()
    {
        VBox newVBox = SetVBox();
        
        this.newPane.add(newVBox, 0,0);
        
    }
    
    @Override
    public void handle(ActionEvent event) 
    {
        Button inputButton = (Button) event.getSource();
        if (inputButton.getId().equals(menuButtons[0].getId()))
        {
            InputView inputForm = new InputView();
            newPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(inputForm.SetInputPane());
            //subPane.setStyle("-fx-background-color: blue;");
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.6));
            newPane.add(subPane, 1, 0);
            
        }
        else if(inputButton.getId().equals(menuButtons[1].getId()))
        {
            LoadView loadForm = new LoadView(this.subPane);
            
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.6));
            
            newPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(loadForm.GetLoadPane());
            
            //subPane.setStyle("-fx-background-color: blue;");
            
            newPane.add(subPane, 1, 0);
        }
        else if(inputButton.getId().equals(menuButtons[2].getId()))
        {
            SaveView saveForm = new SaveView(this.subPane);
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.6));
            
            newPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(saveForm.GetLoadPane());
            
            //subPane.setStyle("-fx-background-color: blue;");
            
            newPane.add(subPane, 1, 0);
            
        }
        else if(inputButton.getId().equals(menuButtons[3].getId()))
        {
            EditView editForm = new EditView();
            newPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(editForm.SetEditPane());
            //subPane.setStyle("-fx-background-color: green;");
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.6));
            newPane.add(subPane, 1, 0);
        }
        else if(inputButton.getId().equals(menuButtons[4].getId()))
        {
            TreeView treeForm = new TreeView();
            newPane.getChildren().remove(subPane);
            subPane.getChildren().clear();
            subPane.getChildren().add(treeForm.SetTreePane());
            //subPane.setStyle("-fx-background-color: green;");
            subPane.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.6));
            newPane.add(subPane, 1, 0);
            
        }
        
    }
    
}
