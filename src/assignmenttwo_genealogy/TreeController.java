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
    
    ArrayList <LeafView> treeList;
    private KTree familyTree;
    
    
    public TreeController()
    {
        
        
    }
    
    private void PopulateFamilyTree()
    {
        for(Map.Entry familyPair:ApplicationController.GetNewInstance().GetTreeDB().familyTree.entrySet())
        {
            Nodi inputNode = (Nodi) familyPair.getValue();
            
            System.out.println("insert success: " + this.familyTree.Insert(inputNode));
            System.out.println("after insertion tree size: " + this.familyTree.GetSize());
        }
    }
    
    /**
     * <p>Setting the depth of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @param root starting node
     */
    private void SetPosition()
    {
        this.familyTree.BreadthFirstTraversal();
        
    }
    
    public ArrayList<LeafView> GetTreeList()
    {
        this.familyTree = new KTree();
        treeList = new ArrayList<>();
        this.PopulateFamilyTree();
        //System.out.println("tree size: " +this.familyTree.GetSize());
        
        this.SetPosition();
        
        for(Map.Entry dbPair:ApplicationController.GetNewInstance().GetTreeDB().familyTree.entrySet())
        {
            Nodi targetNode = (Nodi) dbPair.getValue();
            
            //targetNode.PrintNode();
            
            Leaf targetLeaf = this.familyTree.GetLeafNode(targetNode);
            //System.out.println("###############################");
            //targetLeaf.LeafPrint();
            //System.out.println("###############################");
            if(!targetNode.GetPersonID().isEmpty())
            {
                LeafView newLeafView = new LeafView(targetLeaf);
                Vector2 positionVector = new Vector2(newLeafView.GetNeighbour(), newLeafView.GetGeneration());
                newLeafView.SetLeafPosition(positionVector);
                treeList.add(newLeafView);
            }
            
        }
        
        return this.treeList;
    }
    
}
