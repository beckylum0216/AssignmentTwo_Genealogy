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
import javafx.geometry.Pos;

/**
 *
 * @author becky
 */
public class TreeController 
{
    
    private ArrayList <LeafView> treeList;
   
    private Graph familyTree;
    
    /**
     * <p>Default constructor</p>
     */
    public TreeController()
    {
        
        
    }
    
    /**
     * <p> function to populate the graph with nodes and edges</p>
     */
    private void PopulateFamilyTree()
    {
        ArrayList <Nodi> tempList = new ArrayList<>();
        for(Map.Entry familyPair:ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().entrySet())
        {
            Nodi inputNode = (Nodi) familyPair.getValue();
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            inputNode.PrintNode();
            Nodi parentNode = ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().get(inputNode.GetParentOne());
            this.familyTree.AddEdge(parentNode, inputNode);
            tempList.add(inputNode);
            System.out.println("after insertion tree size: " + this.familyTree.GetAdjList().size());
        }
        
        
        
    }
    
    /**
     * <p> Sets the generation of the node</p>
     * @return 
     */
    private ArrayList<Leaf> SetPosition()
    {
        Nodi rootNode = ApplicationController.GetNewInstance().GetTreeDB().GetRootNode();
        
        ArrayList <Leaf> nodeLevel = new ArrayList<>();
        
        try
        {
            //nodeLevel = this.familyTree.BreadthFirstTraversal(rootNode);
            nodeLevel = this.familyTree.BreadthFirstTraversal(rootNode);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e);
        }
        
        for(Leaf indexLeaf: nodeLevel)
        {
            indexLeaf.LeafPrint();
        }
        return nodeLevel;
        
    }
    
    /**
     * <p> Accessor to create a new graph and positions the labels</p>
     * @return treeList
     */
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
            
            System.out.println("id:"+ newLeafView.GetNodeID() + " generation: " + newLeafView.GetGeneration() + " neighbour: " + newLeafView.GetNeighbour());
            Vector2 positionVector = new Vector2(newLeafView.GetNeighbour(), newLeafView.GetGeneration());
            //newLeafView.GetLeafView().setMinWidth(100);
            //newLeafView.GetLeafView().setMinHeight(20);
            newLeafView.GetLeafView().setAlignment(Pos.CENTER);
            newLeafView.SetLeafPosition(positionVector);
            treeList.add(newLeafView);
            
        }
            
        return this.treeList;
    }
    
}
