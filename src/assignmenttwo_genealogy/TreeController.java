/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author becky
 */
public class TreeController 
{
    
    private ArrayList <LeafView> treeList;
   
    private Graph familyTree;
    
    
    public TreeController()
    {
        
        
    }
    
    private void PopulateFamilyTree()
    {
        for(Map.Entry familyPair:ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().entrySet())
        {
            Nodi inputNode = (Nodi) familyPair.getValue();
            this.familyTree.AddNode(inputNode);
            
            System.out.println("after insertion tree size: " + this.familyTree.GetNodeList().size());
        }
    }
    
    /**
     * <p>Setting the depth of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @param root starting node
     */
    private ArrayList<Leaf> SetPosition()
    {
        Nodi rootNode = ApplicationController.GetNewInstance().GetTreeDB().GetRootNode();
        ArrayList <Leaf> nodeLevel = this.familyTree.BreadthFirstTraversal(rootNode);
        for(Leaf indexLeaf: nodeLevel)
        {
            indexLeaf.LeafPrint();
        }
        return nodeLevel;
        
    }
    
    public ArrayList<LeafView> GetTreeList()
    {
        this.familyTree = new Graph();
        treeList = new ArrayList<>();
        this.PopulateFamilyTree();
        
        // get generation info
        ArrayList <Leaf> leafList = this.SetPosition();
        
        for(int ii = 0; ii < leafList.size(); ii += 1)
        {
            
            LeafView newLeafView = new LeafView(leafList.get(ii));
            System.out.println("#############################################");
            newLeafView.LeafPrint();
            
            System.out.println("id:"+ newLeafView.GetNodeID() + " generation: " + newLeafView.GetGeneration());
            Vector2 positionVector = new Vector2(newLeafView.GetNeighbour(), newLeafView.GetGeneration());
            newLeafView.SetLeafPosition(positionVector);
            treeList.add(newLeafView);
            
        }
            
        return this.treeList;
    }
    
}
