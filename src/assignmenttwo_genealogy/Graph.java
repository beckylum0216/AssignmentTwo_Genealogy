/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import static java.lang.Math.round;
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
    
    
    /**
     * <p>The data structure for the graph</p>
     * @see https://algorithms.tutorialhorizon.com/graph-implementation-adjacency-list-better-set-2/
     */
    private HashMap<String, LinkedList<Leaf>> adjList;
   
    
    Graph()
    {
        this.adjList = new HashMap<>();
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
    
    /**
     * <p>Setting the generation of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @see https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     * @see https://hackernoon.com/graphs-in-cs-and-its-traversal-algorithms-cfee5533f74e
     * @param root starting node
     */
    public ArrayList<Leaf> BreadthFirstTraversal(Nodi firstNode)
    {
        ArrayList <Leaf> nodeLeaf = new ArrayList<>();
        HashMap<String, Leaf> nodeLevel = new HashMap<>();
        ArrayList<Leaf> visitedNode = new ArrayList<>();
        Queue <Leaf> oldList = new LinkedList<>();
        Queue <Leaf> newList = new LinkedList<>();
        
        
        Leaf tempLeaf = new Leaf(firstNode);
        tempLeaf.SetGeneration(0);
        visitedNode.add(tempLeaf);
        oldList.add(tempLeaf);
        nodeLevel.put(tempLeaf.GetNodeID(), tempLeaf);
        
        
        while(!oldList.isEmpty())
        {
            tempLeaf = oldList.poll();
            
            if(this.adjList.containsKey(tempLeaf.GetNodeID()))
            {
                for(int ii = 0; ii < this.adjList.get(tempLeaf.GetNodeID()).size(); ii += 1)
                {
                    Leaf newLeaf = this.adjList.get(tempLeaf.GetNodeID()).get(ii);
                    
                    if(!visitedNode.contains(newLeaf))
                    {
                        newLeaf.SetGeneration(nodeLevel.get(tempLeaf.GetNodeID()).GetGeneration() + 1);
                        newLeaf.SetNeighbour(nodeLevel.get(newLeaf.GetPrimaryParent()).GetNeighbour()+ii);
                        visitedNode.add(newLeaf);
                        oldList.add(newLeaf);
                        nodeLevel.put(newLeaf.GetNodeID(), newLeaf);
                        
                    }
                }
                
                
            }
            else
            {
                
                this.FindLeafNodes();
                this.FindLeftMostSibling();
                this.FindRightMostSibling();
                nodeLevel = this.RepositionChildNodes(nodeLevel);
                nodeLevel = this.SetModPosition(nodeLevel);
                nodeLevel = this.SetAdjustedPosition(nodeLevel);
                
                for(Leaf indexLeaf:nodeLevel.values())
                {
                    
                    nodeLeaf.add(indexLeaf);
                }
        
                return nodeLeaf;
            }
            
        }
        
        return nodeLeaf;
    }
    
    /**
     * <p>Setting the generation of each node</p>
     * @see https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
     * @see https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
     * @param root starting node
     */
    public HashMap<String, Leaf> RepositionChildNodes(HashMap<String, Leaf> inputMap)
    {
        HashMap<String, Leaf> tempMap = inputMap;
        
        int count = 0;
        
        for(Leaf index:tempMap.values())
        {
            
            index.SetNeighbour(count);
            
            
            count++;
        }
        
        return tempMap;
    }
    
    
    /**
     * <p>Helper function for finding leaf node</p>
     * @see https://blacketernal.wordpress.com/2013/06/20/a-c-implementation-of-the-reingold-tilford-tree-layout-algorithm-for-heuristiclab/
     * @param root starting node
     */
    private void FindLeafNodes()
    {
        ArrayList<Leaf> parentList = new ArrayList<>();
        
        for(LinkedList<Leaf> listIndex: this.adjList.values())
        {
            //String parentNodeID = (String)listPair.getKey();
            for(Leaf nodeIndex: listIndex)
            {
                
                Nodi parentNode = ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().get(nodeIndex.GetPrimaryParent());
                Leaf parentLeaf = new Leaf(parentNode);
                parentList.add(parentLeaf);
            }
        }
        
        for(LinkedList <Leaf> listIndex:this.adjList.values())
        {
            for(Leaf leafIndex:listIndex)
            {
                if(!parentList.contains(leafIndex))
                {
                    leafIndex.SetLeafState(Boolean.TRUE);
                }
            }
            
        }   
    }
    
    private void FindLeftMostSibling()
    {
        for(LinkedList <Leaf> listIndex:this.adjList.values())
        {
            for(Leaf leafIndex:listIndex)
            {
                if(leafIndex.GetNeighbour() == 0)
                {
                    leafIndex.SetLeftMostState(Boolean.TRUE);
                }
            }
        }  
    }
    
    private void FindRightMostSibling()
    {
        for(LinkedList <Leaf> listIndex:this.adjList.values())
        {
            listIndex.getLast().SetRightMostState(Boolean.TRUE);
        }
    }
    
    private HashMap<String, Leaf> SetModPosition(HashMap<String, Leaf> inputMap)
    {
        HashMap <Double, ArrayList<Leaf>> generationSiblings = new HashMap<>();
        Double generationMod = 0.0;
        
        // initialise hashmap with empty arraylist
        for(Leaf index:inputMap.values())
        {
            generationSiblings.put(index.GetGeneration(), new ArrayList<Leaf>());
        }
        
        // add sibling nodes
        for(Leaf index:inputMap.values())
        {
            generationSiblings.get(index.GetGeneration()).add(index);
        }
        
        
        for(ArrayList<Leaf> listIndex: generationSiblings.values())
        {
            Double leftMostPosition = 0.0; 
            Double rightMostPosition = 0.0;
            for(Leaf leafIndex:listIndex)
            {
                if(leafIndex.GetLeftMostState() == true)
                {
                    leftMostPosition = leafIndex.GetNeighbour();
                }
                
                if(leafIndex.GetRightMostState() == true)
                {
                    rightMostPosition = leafIndex.GetNeighbour();
                }
            }
            
            Long tempMod = Math.round((leftMostPosition + rightMostPosition) / 2.0);
            generationMod = tempMod.doubleValue();
            
        }
        
        for(Leaf modIndex:inputMap.values())
        {
            modIndex.SetMod(generationMod);
        }
        
        return inputMap;
    }
    
    public HashMap<String, Leaf> SetAdjustedPosition(HashMap<String, Leaf> inputMap)
    {
        ArrayList<Leaf> parentList = new ArrayList<>();
        
        for(LinkedList<Leaf> listIndex: this.adjList.values())
        {
            //String parentNodeID = (String)listPair.getKey();
            for(Leaf nodeIndex: listIndex)
            {
                
                Nodi parentNode = ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().get(nodeIndex.GetPrimaryParent());
                Leaf parentLeaf = new Leaf(parentNode);
                parentList.add(parentLeaf);
            }
        }
        
        
        
        for(Leaf index:inputMap.values())
        {
            if(parentList.contains(index))
            {
                inputMap.get(index.GetPrimaryParent()).SetNeighbour(index.GetMod());
            }
            else
            {
                if(index.GetNeighbour() < index.GetMod())
                {
                    index.SetNeighbour(index.GetNeighbour() - 1);
                }
                else
                {
                    index.SetNeighbour(index.GetNeighbour() + 1);
                }
            }
            
        }
        
        return inputMap;
    }
    
}
