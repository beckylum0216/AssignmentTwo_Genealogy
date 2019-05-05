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
    
    private HashMap<String, ArrayList<LeafView>> familyTree;
    
    
    public TreeController(HashMap<String, ArrayList<LeafView>> inputMap)
    {
        System.out.println("input map size: "+ inputMap.size());
        // deep copy required
        
        this.familyTree = inputMap;
        
    }
    
    /**
     * <p>Setting the depth of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @param root starting node
     */
    private void SetPositionY()
    {
        Queue <LeafView> nodeQueue = new LinkedList<>();
        HashMap<String, Boolean> nodeFlags = new HashMap<>();
        HashMap<String, Integer> nodeLevel = new HashMap<>();
        
        Leaf root = TreeManager.GetInstance().GetRootNode();
        LeafView rootView = new LeafView(root);
        
        nodeFlags.put(rootView.GetPersonID(), Boolean.TRUE);
        nodeLevel.put(rootView.GetParentOne(), 0);
        
        
        this.familyTree.get(rootView.GetParentOne()).get(this.GetIndex(rootView)).GetLeafPosition().SetY(0);
        
        LeafView targetNode = rootView;

        for(Map.Entry adjPair : this.familyTree.entrySet())
        {
            String adjKey = (String) adjPair.getKey();
            ArrayList<LeafView> adjList = (ArrayList<LeafView>) adjPair.getValue();

            for(int ii = 0; ii < adjList.size(); ii += 1)
            {
                if(!nodeFlags.containsKey(adjList.get(ii).GetPersonID()))
                {
                    if(!nodeLevel.containsKey(adjList.get(ii).GetParentOne()))
                    {
                        nodeFlags.put(adjList.get(ii).GetPersonID(), Boolean.TRUE);
                        nodeLevel.put(adjList.get(ii).GetParentOne(), nodeLevel.get(targetNode.GetParentOne())+1);
                        int tempLevel = nodeLevel.get(adjList.get(ii).GetParentOne());
                        this.familyTree.get(adjList.get(ii).GetParentOne()).get(this.GetIndex(adjList.get(ii))).GetLeafPosition().SetY(tempLevel);
                        targetNode = adjList.get(ii);
                    }
                    else
                    {
                        nodeFlags.put(adjList.get(ii).GetPersonID(), Boolean.TRUE);
                        nodeLevel.put(adjList.get(ii).GetParentOne(), nodeLevel.get(targetNode.GetParentOne()));
                        int tempLevel = nodeLevel.get(adjList.get(ii).GetParentOne());
                        this.familyTree.get(adjList.get(ii).GetParentOne()).get(this.GetIndex(adjList.get(ii))).GetLeafPosition().SetY(tempLevel);
                        targetNode = adjList.get(ii);
                    }
                    
                }
            }   
        }
        
        for(Map.Entry tempPair:nodeLevel.entrySet())
        {
            String tempKey = (String)tempPair.getKey();
            Integer tempLevel = (Integer) tempPair.getValue();
            
            System.out.println("node: "+ tempKey + " " + tempLevel);
        }
        
        
    }
    
    
    
    /**
     * <p>Finding the index of the targetNode. indexof does not work</p>
     * 
     * @param root starting node
     */
    private int GetIndex(LeafView targetNode)
    {
        ArrayList <LeafView> sourceList = this.familyTree.get(targetNode.GetParentOne());
        for(int ii = 0; ii < sourceList.size(); ii += 1)
        {
            if(sourceList.get(ii).GetPersonID() == targetNode.GetPersonID())
            {
                return ii;
            }
        }
        
        return -1;
    }
    
    /**
     * <p>Setting the X position of each node</p>
     * @param root starting node
     */
    private void SetPositionX()
    {
        for(Map.Entry leafPair:this.familyTree.entrySet())
        {
            ArrayList<LeafView> targetList = (ArrayList <LeafView>) leafPair.getValue();
            
            for(int ii = 0; ii < targetList.size(); ii += 1)
            {
                targetList.get(ii).GetLeafPosition().SetX(ii);
            }
            
        }
    }
    
    private void CheckOverlaps()
    {
        for(Map.Entry leafPair: this.familyTree.entrySet())
        {
            ArrayList<LeafView> targetList = (ArrayList <LeafView>) leafPair.getValue();
           
            
            for(int ii = 0; ii < targetList.size(); ii += 1)
            {
                LeafView targetNode = targetList.get(ii);
                
                for(Map.Entry checkPair:this.familyTree.entrySet())
                {
                    ArrayList<LeafView> sourceList = (ArrayList <LeafView>) leafPair.getValue();
                    
                    for(int jj = 0; jj < sourceList.size(); jj += 1)
                    {
                        LeafView sourceNode = sourceList.get(jj);
                        if(targetNode.GetLeafPosition().GetX() == sourceNode.GetLeafPosition().GetX())
                        {
                            int currentPosition = sourceNode.GetLeafPosition().GetX();
                            sourceNode.GetLeafPosition().SetX(currentPosition + 1);
                        }
                        
                        if(targetNode.GetLeafPosition().GetY() == sourceNode.GetLeafPosition().GetY())
                        {
                            int currentPosition = sourceNode.GetLeafPosition().GetY();
                            sourceNode.GetLeafPosition().SetY(currentPosition + 1);
                        }
                    }
                }
            }
        }
    }
    
    
    
    
    public HashMap<String, ArrayList<LeafView>> GetFamilyTree()
    {
        System.out.println("Running family tree...");
        this.SetPositionY();
        this.SetPositionX();
        //this.CheckOverlaps();
        return this.familyTree;
    }
    
}
