/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class TreeView {
    
    TreeManager dataGraph;
    HashMap<String, LeafView> activeView;
    
    public TreeView(TreeManager inputGraph)
    {
        this.dataGraph = inputGraph;
        this.activeView = new HashMap<>();
    }
    
    public Pane SetTreePane()
    {
        Pane newPane = new Pane();
        // add nodes
        for(Map.Entry graphPair: dataGraph.GetFamilyTree().entrySet())
        {
            Leaf drawNode = (Leaf) graphPair.getValue();
            LeafView graphNode = new LeafView(drawNode);
            
            double positionX = newPane.widthProperty().divide(2.0).doubleValue();
            
            
            
            
            graphNode.GetLeafView().relocate(0, 0);
            activeView.put(graphNode.GetPersonID(), graphNode);
            newPane.getChildren().add(graphNode.GetLeafView());
            
        }
        
       
        
        // add spouse edges
        for(Map.Entry edgePair: activeView.entrySet())
        {
            if(dataGraph.GetFamilyTree().size() > 1)
            {
                LeafView parentNode = (LeafView)edgePair.getValue();
                LeafView spouseNode;
                if(activeView.containsKey(parentNode.GetPersonSpouse()))
                {
                    spouseNode = activeView.get(parentNode.GetPersonSpouse());
                    EdgeView graphEdge = new EdgeView(parentNode, spouseNode);
                    newPane.getChildren().add(graphEdge.SetEdgeView());
                }
            }
        }
        
        
        
        
        
        return newPane;
    }
    
    
    
}
