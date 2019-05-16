/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author becky
 */
public class LeafView extends Leaf
{
    
    private Vector2 leafPosition;
    private float modifier;
    private Vector2 minOffSet;
    private Vector2 maxOffSet;
    private Boolean IsLeaf;
    Label leafLabel;
    
    LeafView(Leaf inputNode)
    {
        super(inputNode);
        this.leafPosition = new Vector2(0f,0f);
        this.modifier = 0;
        this.leafLabel = new Label(inputNode.GetFirstName()+" "+ inputNode.GetLastName());
        BackgroundFill nodeFill = new BackgroundFill(Color.web("92E4F0"), CornerRadii.EMPTY, Insets.EMPTY);
        Background nodeBackground = new Background(nodeFill);
        this.leafLabel.setBackground(nodeBackground);
        this.leafLabel.setMinWidth(100);
        this.leafLabel.setMinHeight(25);
    }
    
    public void SetLeafPosition(Vector2 inputPosition)
    {
        this.leafPosition = inputPosition;
    }
    
    public Vector2 GetLeafPosition()
    {
        return this.leafPosition;
    }
    
    public void AddLeafView()
    {
        leafLabel = new Label(this.GetFirstName()+" "+ this.GetLastName());
        BackgroundFill nodeFill = new BackgroundFill(Color.web("92E4F0"), CornerRadii.EMPTY, Insets.EMPTY);
        Background nodeBackground = new Background(nodeFill);
        leafLabel.setBackground(nodeBackground);
    }
    
    public Label GetLeafView()
    {
        return leafLabel;
    }
    
    
    
    
}
