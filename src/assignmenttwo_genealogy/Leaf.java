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
    private int generation;
    private ArrayList<Leaf> children;
    
    
    Leaf(Nodi inputNode)
    {
        this.nodeID = inputNode.GetPersonID();
        this.firstName = inputNode.GetFirstName();
        this.lastName = inputNode.GetLastNameBirth();
        //this.siblings = new ArrayList<>();
        this.generation = 0;
        this.children = new ArrayList<>();
    }
    
    Leaf(Leaf inputLeaf)
    {
        this.nodeID = inputLeaf.GetNodeID();
        this.firstName = inputLeaf.GetFirstName();
        this.lastName = inputLeaf.GetLastName();
        this.generation = 0;
        //this.siblings = new ArrayList<>();
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
    
    public void SetGeneration(int inputGeneration)
    {
        this.generation = inputGeneration;
    }
    
    public int GetGeneration()
    {
        return this.generation;
    }
    
    /*
    public void SetSiblings(ArrayList<String> inputSiblings)
    {
        this.siblings = inputSiblings;
    }
    
    public ArrayList<String> GetSiblings()
    {
        return this.siblings;
    }
    */
    
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
    
    
            
    
}
