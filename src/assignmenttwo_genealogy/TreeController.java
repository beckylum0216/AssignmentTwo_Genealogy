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
    
    
    private ArrayList<Leaf> SetPosition()
    {
        Nodi rootNode = ApplicationController.GetNewInstance().GetTreeDB().GetRootNode();
        System.out.println("Root node ########################");
        rootNode.PrintNode();
        ArrayList <Leaf> nodeLevel = new ArrayList<>();
        
        try
        {
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
