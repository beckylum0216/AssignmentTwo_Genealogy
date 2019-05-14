/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author becky
 */
public class Graph {
    
    
    
    private HashMap<String, LinkedList<Leaf>> adjList;
   
    
    Graph()
    {
       
        this.adjList = new HashMap<>();
        
    }
    
    
    public void AddEdge(Nodi sourceNode, Nodi destinationNode)
    {
        Leaf sourceLeaf = new Leaf(sourceNode);
        Leaf destinationLeaf = new Leaf(destinationNode);
        
        if(!this.adjList.containsKey(sourceLeaf.GetNodeID()))
        {
            LinkedList<Leaf> newList = new LinkedList<>();
            newList.add(destinationLeaf);
            this.adjList.put(sourceLeaf.GetNodeID(), newList);
        }
        else
        {
            this.adjList.get(sourceLeaf.GetNodeID()).add(destinationLeaf);
        }
        
    }
    
    public void SetAdjList(HashMap<String, LinkedList<Leaf>> inputAdjList)
    {
        this.adjList = inputAdjList;
    }
    
    public HashMap<String, LinkedList<Leaf>> GetAdjList()
    {
        return this.adjList;
    }
    
    public void PrintAdjList()
    {
        for(LinkedList<Leaf> index:this.adjList.values())
        {
            for(Leaf indexNode: index)
            {
                indexNode.LeafPrint();
            }
        }
    }
    
    /**
     * <p>Setting the depth of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @param root starting node
     */
    public ArrayList<Leaf> BreadthFirstTraversal(Nodi firstNode)
    {
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        PrintAdjList();
        System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
        
        ArrayList <Leaf> nodeLeaf = new ArrayList<>();
        HashMap<String, Leaf> nodeLevel = new HashMap<>();
        ArrayList<Leaf> visitedNode = new ArrayList<>();
        Queue <Leaf> list = new LinkedList<>();
        
        Leaf tempLeaf = new Leaf(firstNode);
        tempLeaf.SetGeneration(0);
        visitedNode.add(tempLeaf);
        list.add(tempLeaf);
        nodeLevel.put(tempLeaf.GetNodeID(), tempLeaf);
        
        while(!list.isEmpty())
        {
            tempLeaf = list.poll();
            System.out.println("parent element: " + tempLeaf.GetNodeID() + " list size: " + list.size());
            
            if(this.adjList.containsKey(tempLeaf.GetNodeID()))
            {
                for(int ii = 0; ii < this.adjList.get(tempLeaf.GetNodeID()).size(); ii += 1)
                {

                        Leaf newLeaf = this.adjList.get(tempLeaf.GetNodeID()).get(ii);

                        if(!visitedNode.contains(newLeaf))
                        {
                            newLeaf.SetGeneration(nodeLevel.get(tempLeaf.GetNodeID()).GetGeneration() + 1);
                            visitedNode.add(newLeaf);
                            list.add(newLeaf);
                            nodeLevel.put(newLeaf.GetNodeID(), newLeaf);
                        }
                }
            }
            else
            {
                for(Leaf indexLeaf:nodeLevel.values())
                {
                    nodeLeaf.add(indexLeaf);
                }
        
                return nodeLeaf;
            }
            
        }
        
        return nodeLeaf;
    }
    
    
    
    
    
    
    
    
    
}
