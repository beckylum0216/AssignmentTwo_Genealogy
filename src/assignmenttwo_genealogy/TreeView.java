/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
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
    
    
    ArrayList<LeafView> activeView;
    TreeController treeHandler;
    
    public TreeView()
    {
        
        this.activeView = new ArrayList<>();
    }
    
    public Pane SetTreePane()
    {
        treeHandler = new TreeController();
        double labelWidth = 100.0;
        double labelMargin = 20.0;
        double labelHeight = 20.0;
        
        Pane newPane = new Pane();
        
        this.activeView = treeHandler.GetTreeList();
        
        System.out.println("activeview size: " + this.activeView.size());
        
        // add nodes
        for(int ii = 0; ii < this.activeView.size(); ii += 1)
        {
            if(!this.activeView.get(ii).GetNodeID().equals("root001"))
            {
                this.activeView.get(ii).GetLeafView().layoutXProperty()
                                .bind(newPane.widthProperty()
                                .subtract(this.activeView.get(ii)
                                .GetLeafView().widthProperty()).divide(2));

                this.activeView.get(ii).GetLeafView().setTranslateX((double)this.activeView.get(ii).GetLeafPosition().GetX() * (labelWidth + labelMargin));
                this.activeView.get(ii).GetLeafView().setTranslateY((double)this.activeView.get(ii).GetLeafPosition().GetY() * (labelHeight + labelMargin));
                newPane.getChildren().add(this.activeView.get(ii).GetLeafView());
            }
        }
        
        return newPane;
    }
    
    
    
}
