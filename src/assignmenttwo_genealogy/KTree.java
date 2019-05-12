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
import java.util.TreeSet;

/**
 *
 * @author becky
 */
public class KTree {
    
    private Leaf rootNode;
    private int size;
    
    KTree()
    {
        this.rootNode = null;
        this.size = 0;
    }
    
    public int GetSize()
    {
        return this.size;
    }
    
    
    
    public Boolean Insert(Nodi inputNode)
    {
        return InsertNode(rootNode, inputNode);
    }
    
    private Boolean InsertNode(Leaf currentNode, Nodi inputNode)
    {
        
        Leaf newNode = new Leaf(inputNode);
        
        if(rootNode == null)
        {
            rootNode = newNode;
            this.size++;
            System.out.println(this.size);
            return true;
        }
        
        
        
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        
        // 3rd generation won't insert!!!!!!!!!!!!!!!!!!!!!!!1
        if(currentNode.GetChildren().isEmpty()) // <===== this is stupid! i have lost my mind here
        {
            
            newNode.LeafPrint();
            System.out.println("Added leaf!!!");
            currentNode.AddChild(newNode); //<--Here is the error? 3rd generation insertion won't happen
            //System.out.println("array size: " + currentNode.GetChildren().size());
            this.size++;
            System.out.println("new leaf insertion size: "+this.size);
            return true;
        }
        else
        {
            //add siblings
            if(newNode.GetPrimaryParent().equals(currentNode.GetNodeID()))
            {
                //System.out.println("current node: " + currentNode.GetNodeID() + " input parent node: "+ newNode.GetPrimaryParent());
                currentNode.AddChild(newNode);
                this.size++;
                System.out.println("new sibling insertion: "+this.size);
                return true;
            
            }
            else 
            {
                // go down one generation
                for(int ii = 0; ii < currentNode.GetChildren().size(); ii += 1)
                {
                    this.InsertNode(currentNode.GetChildren().get(ii), inputNode);
                }
                return false;
            }
        }
        
    }
    
    
    public boolean BreadthFirstTraversal()
    {
        if(rootNode == null)
        {
            throw new IllegalArgumentException("Empty Tree!!!");
        }
        
        return this.BreadthFirstTraversal(rootNode, 0f);
    }
    
    public boolean BreadthFirstTraversal(Leaf currentNode, double currentGeneration)
    {
        if(rootNode == null)
        {
            return false;
        }
        
        currentGeneration++;
        currentNode.SetGeneration(currentGeneration);
        System.out.println("generation: " + currentGeneration);
        
        
        if(!currentNode.GetChildren().isEmpty())
        {
            
            for(int ii = 0; ii < currentNode.GetChildren().size(); ii += 1)
            {
                BreadthFirstTraversal(currentNode.GetChildren().get(ii), currentGeneration);
            }
        }
        
        return true;
    }
    
    public Leaf GetLeafNode(Nodi inputNode)
    {
        //System.out.println("tree size: " +this.size);
        return GetTargetNode(rootNode, inputNode);
    }
    
    private Leaf GetTargetNode(Leaf currentNode, Nodi inputNode)
    {
        Leaf targetNode = new Leaf(inputNode);
        
        
        System.out.println("current: " + currentNode.GetNodeID() + " target: " + targetNode.GetNodeID());
        
        if(currentNode.GetNodeID().equals(targetNode.GetNodeID()))
        {
            
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            currentNode.LeafPrint();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            return currentNode;
        }
        else
        {   
            // recursively go through the tree to find node
            for(int ii = 0; ii < currentNode.GetChildren().size(); ii += 1)
            {
                GetTargetNode(currentNode.GetChildren().get(ii), inputNode);
            }
            
            return null;
            
        }
        
        
    }
    
    
    
    
    
}
