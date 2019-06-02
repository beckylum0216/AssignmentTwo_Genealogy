/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 *
 * @author becky
 */
public class ApplicationView {
    StackPane newPane;
    
    ApplicationView()
    {
        newPane = new StackPane();
        Label introLabel = new Label("TreeSoft");
        introLabel.setFont(Font.font("Arial", FontPosture.ITALIC,96));
        introLabel.setLayoutX(introLabel.getLayoutBounds().getWidth()/2);
        
        newPane.getChildren().add(introLabel);
        
    }
    
    public StackPane GetNewPane()
    {
        return this.newPane;
    }
}
