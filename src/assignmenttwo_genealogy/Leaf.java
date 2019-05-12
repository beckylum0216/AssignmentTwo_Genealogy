/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;

/**
 *
 * @author becky
 */
public class Leaf {

    private String nodeID;
    private String firstName;
    private String lastName;
    private String primaryParent;
    private double generation;
    private double neighbour;
    private ArrayList<Leaf> children;
    
    
    Leaf(Nodi inputNode)
    {
        this.nodeID = inputNode.GetPersonID();
        this.firstName = inputNode.GetFirstName();
        this.lastName = inputNode.GetLastNameBirth();
        this.primaryParent = inputNode.GetParentOne();
        //this.siblings = new ArrayList<>();
        this.generation = 0;
        this.neighbour = 0;
        this.children = new ArrayList<>();
    }
    
    Leaf(Leaf inputLeaf)
    {
        this.nodeID = inputLeaf.GetNodeID();
        this.firstName = inputLeaf.GetFirstName();
        this.lastName = inputLeaf.GetLastName();
        this.primaryParent = inputLeaf.primaryParent;
        this.generation = 0;
        this.neighbour = 0;
        this.children = new ArrayList<>();
    }
    
    public void SetNodeID(String inputID)
    {
        this.nodeID = inputID;
    }
    
    public String GetNodeID()
    {
        return this.nodeID;
    }
    
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    public String GetFirstName()
    {
        return this.firstName;
    }
    
    public void SetLastName(String inputLastName)
    {
        this.lastName = inputLastName;
    }
    
    public String GetLastName()
    {
        return this.lastName;
    }
    
    public void SetPrimaryParent(String inputParent)
    {
        this.primaryParent = inputParent;
    }
    
    public String GetPrimaryParent()
    {
        return this.primaryParent;
    }
    
    public void SetGeneration(double inputGeneration)
    {
        this.generation = inputGeneration;
    }
    
    public double GetGeneration()
    {
        return this.generation;
    }
    
    
    public void SetNeighbour(double inputNeighbour)
    {
        this.neighbour = inputNeighbour;
    }
    
    public double GetNeighbour()
    {
        return this.neighbour;
    }
    
    
    public void AddChild(Leaf inputChild)
    {
        this.children.add(inputChild);
    }
    
    public void SetChildren(ArrayList<Leaf> inputChildren)
    {
        this.children = inputChildren;
    }
    
    public ArrayList<Leaf> GetChildren()
    {
        return this.children;
    }
    
    public Leaf GetChild(String inputID)
    {
        for(int ii = 0; ii < this.children.size(); ii += 1)
        {
            if(this.children.get(ii).nodeID.equals(inputID))
            {
                return this.children.get(ii);
            }
            
        }
        
        return null;
    }
    
    public void LeafPrint()
    {
        for(int ii = 0; ii < this.children.size(); ii += 1)
        {
            System.out.println("id: " + this.children.get(ii).nodeID);
        }
    }
    
    public Boolean IsEqual(Leaf targetNode)
    {
        Boolean nodeFlag = false;
        
        if(this.nodeID == targetNode.GetNodeID())
        {
            if(this.firstName == targetNode.GetFirstName())
            {
                if(this.lastName == targetNode.GetLastName())
                {
                    nodeFlag = true;
                }
                else
                {
                    nodeFlag = false;
                }
                
            }
            else
            {
                nodeFlag = false;
            }
        }
        else
        {
            nodeFlag = false;
        }
        
        return nodeFlag;
    }
            
    
}
