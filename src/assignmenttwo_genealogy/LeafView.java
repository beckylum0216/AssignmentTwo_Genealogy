/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author becky
 */
public class LeafView extends Leaf {
    
    LeafView(Leaf inputNode)
    {
        super(inputNode);        
    }
    
    public StackPane GetLeafView()
    {
        Rectangle nodeCell = new Rectangle(150,50);
        nodeCell.setFill(Color.web("92E4F0"));
        StackPane infoPane = new StackPane();
        Text infoName = new Text();
        infoName.setText(this.GetFirstName()+" "+this.GetLastNameBirth());
        infoPane.getChildren().add(nodeCell);
        infoPane.getChildren().add(infoName);
        
        return infoPane;
    }
    
    
    
}
