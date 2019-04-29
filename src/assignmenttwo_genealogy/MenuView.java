/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.lang.reflect.Method;
import javafx.application.Application;
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
public class MenuView extends Application {
    
    GridPane newPane;
    MenuController menuHandler;
    String[] bText = {"New", "Open", "Save", "Edit", "View"};
    Button[] menuButtons = new Button[bText.length];
    Scene menuScene;
   
    
    //https://stackoverflow.com/questions/30679025/graph-visualisation-like-yfiles-in-javafx
    @Override
    public void start(Stage inputStage)
    {
        
        this.newPane = new GridPane();
        this.menuScene = new Scene(newPane, 1280, 1024);
        this.menuHandler = new MenuController();
        this.SetGridPane();
        this.SetButtonEvent();
        
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
            menuButtons[ii].setMaxWidth(Double.MAX_VALUE);
            vMenu.getChildren().add(menuButtons[ii]);
        }
        
        //vMenu.setStyle("-fx-background-color: white;");
        vMenu.prefWidthProperty().bind(this.menuScene.widthProperty().multiply(0.3));
        return vMenu;
        
    }
    
    private void SetButtonEvent()
    {
        this.menuHandler.SetMenuPane(newPane);
        for(int ii = 0; ii < bText.length; ii += 1)
        {
            this.menuHandler.AddMenuButtons(menuButtons[ii]);
            menuButtons[ii].setOnAction(click->menuHandler.handle(click));
        }
    }
    
    private void SetGridPane()
    {
        VBox newVBox = SetVBox();
        
        this.newPane.add(newVBox, 0,0);
        
    }
    
    
    
}
