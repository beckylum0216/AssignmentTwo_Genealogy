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
    
    private Set<Nodi> nodeList;
    private Set<Edge> edgeList;
    private Map<Nodi, Set<Edge>> adjList;
   
    
    Graph()
    {
        this.nodeList = new HashSet<>();
        this.edgeList = new HashSet<>();
        this.adjList = new HashMap<>();
        
    }
    
   
    public void AddNode(Nodi inputNode)
    {
        this.nodeList.add(inputNode);
    }
    
    public Set<Nodi> GetNodeList()
    {
        return this.nodeList;
    }
    
    public void AddEdge(Edge inputEdge)
    {
        this.edgeList.add(inputEdge);
    }
    
    public Set<Edge> GetEdgeList()
    {
        return this.edgeList;
    }
    
    public void SetAdjList(Map<Nodi, Set<Edge>> inputAdjList)
    {
        this.adjList = inputAdjList;
    }
    
    public Map<Nodi, Set<Edge>> GetAdjList()
    {
        return this.adjList;
    }
    
    public ArrayList<Leaf> BreadthFirstTraversal(Nodi firstNode)
    {
        ArrayList <Leaf> nodeLeaf = new ArrayList<>();
        HashMap<String, Leaf> nodeLevel = new HashMap<>();
        ArrayList<Nodi> visitedNode = new ArrayList<>();
        Queue <Leaf> list = new LinkedList<>();
        
        Leaf tempLeaf = new Leaf(firstNode);
        tempLeaf.SetGeneration(0);
        visitedNode.add(firstNode);
        list.add(tempLeaf);
        nodeLevel.put(tempLeaf.GetNodeID(), tempLeaf);
        
        while(!list.isEmpty())
        {
            tempLeaf = list.element();
            System.out.println("first element: " + tempLeaf.GetGeneration());
            list.remove();
            
            for(Nodi tempNode: nodeList)
            {
                if(!visitedNode.contains(tempNode))
                {
                    Leaf newLeaf = new Leaf(tempNode);
                    newLeaf.SetGeneration(nodeLevel.get(tempLeaf.GetNodeID()).GetGeneration() + 1);
                    visitedNode.add(tempNode);
                    list.add(newLeaf);
                    nodeLevel.put(newLeaf.GetNodeID(), newLeaf);
                }
            }
            
        }
        
        for(Leaf indexLeaf:nodeLevel.values())
        {
            nodeLeaf.add(indexLeaf);
        }
        
        return nodeLeaf;
    }
    
    
    
    
    
    
    
    
    
}
