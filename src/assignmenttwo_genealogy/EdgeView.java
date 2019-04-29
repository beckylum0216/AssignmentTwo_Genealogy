/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.geometry.Bounds;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;

/**
 *
 * @author becky
 */
public class EdgeView {
    private LeafView parentNode;
    private LeafView targetNode;
    
    EdgeView(LeafView inputParent, LeafView inputTarget)
    {
        this.parentNode = inputParent;
        this.targetNode = inputTarget;
        
    }
    
    public Line SetEdgeView()
    {
        Line edgeLine = new Line();
        Bounds startX = this.parentNode.GetLeafView().localToScene(this.parentNode.GetLeafView().getBoundsInLocal());
        Bounds startY = this.parentNode.GetLeafView().localToScene(this.parentNode.GetLeafView().getBoundsInLocal());
        Bounds endX = this.targetNode.GetLeafView().localToScene(this.targetNode.GetLeafView().getBoundsInLocal());
        Bounds endY = this.targetNode.GetLeafView().localToScene(this.targetNode.GetLeafView().getBoundsInLocal());
        
        edgeLine.setStartX(startX.getWidth()/2);
        edgeLine.setStartY(startY.getHeight()/2);
        edgeLine.setEndX(endX.getWidth()/2);
        edgeLine.setEndY(endY.getHeight()/2);
        
        return edgeLine;
    }
}
