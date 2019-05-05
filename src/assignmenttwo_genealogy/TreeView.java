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
    
    HashMap<String, ArrayList<LeafView>> activeView;
    TreeController treeHandler;
    
    public TreeView()
    {
        this.activeView = new HashMap<>();
    }
    
    public Pane SetTreePane()
    {
        double labelWidth = 40.0;
        double labelMargin = 10.0;
        double labelHeight = 15.0;
        
        Pane newPane = new Pane();
        
        System.out.println("treeManager size: " + TreeManager.GetInstance().GetFamilyTree().size());
        
        // add nodes
        for(Map.Entry graphPair: TreeManager.GetInstance().GetFamilyTree().entrySet())
        {
            ArrayList<Leaf> drawList = (ArrayList<Leaf>) graphPair.getValue();
            for(int ii = 0; ii < drawList.size(); ii += 1)
            {
                
                if(this.activeView.containsKey(drawList.get(ii).GetParentOne()))
                {
                    LeafView graphNode = new LeafView(drawList.get(ii));
                    activeView.get(drawList.get(ii).GetParentOne()).add(graphNode);
                }
                else
                {
                    LeafView graphNode = new LeafView(drawList.get(ii));
                    ArrayList<LeafView> tempList = new ArrayList<>();
                    tempList.add(graphNode);
                    activeView.put(graphNode.GetParentOne(), tempList);
                    System.out.println("activeView list size check1 : " + this.activeView.get(graphNode.GetParentOne()).size());
                }
            }
            
        }
        
        
        
        TreeController treeHandler = new TreeController(this.activeView);
        this.activeView = treeHandler.GetFamilyTree();
        
        System.out.println("activeView size: " + this.activeView.size());
        
        for(Map.Entry treePair: this.activeView.entrySet())
        {
            ArrayList<LeafView> targetList = (ArrayList<LeafView>) treePair.getValue();
            for(int ii = 0; ii < targetList.size(); ii += 1)
            {
                if(!(targetList.get(ii).GetPersonID() == "root001"))
                {
                    targetList.get(ii).GetLeafView().layoutXProperty()
                            .bind(newPane.widthProperty()
                                    .subtract(targetList.get(ii).GetLeafView().widthProperty()).divide(2));
                    
                    targetList.get(ii).GetLeafView().setTranslateX((double)targetList.get(ii).GetLeafPosition().GetX() * (labelWidth + labelMargin));
                    targetList.get(ii).GetLeafView().setTranslateY((double)targetList.get(ii).GetLeafPosition().GetY() * (labelHeight + labelMargin));
                }
            }
        }
        
        for(Map.Entry activePair: this.activeView.entrySet())
        {
            ArrayList<LeafView> targetList = (ArrayList<LeafView>) activePair.getValue();
            for(int ii = 0; ii < targetList.size(); ii += 1)
            {
                if(!(targetList.get(ii).GetPersonID() == "root001"))
                {
                    newPane.getChildren().add(targetList.get(ii).GetLeafView());
                }
                
            }
        }
        
        return newPane;
    }
    
    
    
}
