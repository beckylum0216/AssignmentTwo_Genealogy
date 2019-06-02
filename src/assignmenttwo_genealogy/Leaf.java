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
    private Boolean IsLeaf;
    private Boolean IsLeftMost;
    private Boolean IsRightMost;
    private double mod;
    
    /**
     * <p>Default constructor for the leaf node of the graph</p>
     */
    Leaf()
    {
        this.generation = 0;
        this.neighbour = 0;
        this.children = new ArrayList<>();
    }
    
    /**
     * <p>Parameterised constructor for the leaf node of the graph</p>
     * @param inputNode target nod to be created
     */
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
        this.IsLeaf = false;
        this.IsLeftMost = false;
        this.IsRightMost = false;
    }
    
    /**
     * <p>parameterised constructor for leaf node</p>
     * @param inputLeaf 
     */
    Leaf(Leaf inputLeaf)
    {
        this.nodeID = inputLeaf.GetNodeID();
        this.firstName = inputLeaf.GetFirstName();
        this.lastName = inputLeaf.GetLastName();
        this.primaryParent = inputLeaf.primaryParent;
        this.generation = inputLeaf.GetGeneration();
        this.neighbour = inputLeaf.GetNeighbour();
        this.children = new ArrayList<>();
    }
    
    /**
     * <p>Mutator for the node id</p>
     * @param inputID entered node ID 
     */
    public void SetNodeID(String inputID)
    {
        this.nodeID = inputID;
    }
    
    /**
     * Accessor for the nodeId
     * @return nodeID
     */
    public String GetNodeID()
    {
        return this.nodeID;
    }
    
    /**
     * <p>Mutator to the First name</p>
     * @param inputFirstName first name
     */
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    /**
     * <p> Accessor to the first name field</p>
     * @return  firstName
     */
    public String GetFirstName()
    {
        return this.firstName;
    }
    
    /**
     * <p>Mutator for the last name</p>
     * @param inputLastName last name input
     */
    public void SetLastName(String inputLastName)
    {
        this.lastName = inputLastName;
    }
    
    /**
     * <p>Accessor to the last name </p>
     * @return lastName 
     */
    public String GetLastName()
    {
        return this.lastName;
    }
    
    /**
     * <p>Mutator to the parent field </p>
     * @param inputParent parent data input
     */
    public void SetPrimaryParent(String inputParent)
    {
        this.primaryParent = inputParent;
    }
    
    /**
     * <p>Accessor to the parent field</p>
     * @return primaryParent
     */
    public String GetPrimaryParent()
    {
        return this.primaryParent;
    }
    
    /**
     * <p>Mutator to set generational data</p>
     * @param inputGeneration generation of the siblings
     */
    public void SetGeneration(double inputGeneration)
    {
        this.generation = inputGeneration;
    }
    
    /**
     * <p>Accessor to get generational data </p>
     * @return generation generation of the siblings
     */
    public double GetGeneration()
    {
        return this.generation;
    }
    
    /**
     * <p>Mutator for the neighbour field</p>
     * @param inputNeighbour actually siblings and cousins of the same generation
     */
    public void SetNeighbour(double inputNeighbour)
    {
        this.neighbour = inputNeighbour;
    }
    
    /**
     * <p>Accessor to the neighbour field </p>
     * @return neighbour
     */
    public double GetNeighbour()
    {
        return this.neighbour;
    }
    
    /**
     * <p>Mutator to record child nodes</p>
     * @param inputChild target child
     */
    public void AddChild(Leaf inputChild)
    {
        this.children.add(inputChild);
    }
    
    /**
     * <p>Mutator to record children nodes</p>
     * @param inputChildren target Children
     */
    public void SetChildren(ArrayList<Leaf> inputChildren)
    {
        this.children = inputChildren;
    }
    
    /**
     * <p>Accessor to get all the children nodes</p>
     * @return children children nodes
     */
    public ArrayList<Leaf> GetChildren()
    {
        return this.children;
    }
    
    /**
     * <p> Accessor to get a specific child node </p>
     * @param inputID target node
     * @return target node
     */
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
    
    /**
     * <p>Utility function to print leaf nodes to the screen</p>
     */
    public void LeafPrint()
    {
        
        System.out.println("id: " + this.nodeID);
        System.out.println("name: " + this.firstName);
        System.out.println("generation: " + this.GetGeneration());   
        
    }
    
    /**
     * <p> Utility function to check if two nodes are the same </p>
     * @param targetNode the node to be checked
     * @return nodeFlag a boolean on whether the node is equal
     */
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
    
    /**
     * <p>Mutator to set whether a node is a leaf</p>
     * @param inputState boolean state
     */
    public void SetLeafState(Boolean inputState)
    {
        this.IsLeaf = inputState;
    }
    
    /**
     * <p>Accessor to the child state </p>
     * @return IsLeaf the child state
     */
    public Boolean GetLeafState()
    {
        return this.IsLeaf;
    }
    
    /**
     * <p>Indicator if it is the left most node in the generation</p>
     * @param inputState left most state
     */
    public void SetLeftMostState(Boolean inputState)
    {
        this.IsLeftMost = inputState;
    }
    
    /**
     * Accessor to the left most leaf state
     * @return IsLeftMost
     */
    public Boolean GetLeftMostState()
    {
        return this.IsLeftMost;
    }
    
    /**
     * <p>Mutator to set the right most node for the generation</p>
     * @param inputState rightmost boolean
     */
    public void SetRightMostState(Boolean inputState)
    {
        this.IsRightMost = inputState;
    }
    
    /**
     * <p>Accessor to get the right most node for the generation</p>
     * @return IsRightMost rightmost boolean
     */
    public Boolean GetRightMostState()
    {
        return this.IsRightMost;
    }
    
    /**
     * <p>Mutator to the middle node</p>
     * @param inputMod calculate middle of the generation
     */
    public void SetMod(double inputMod)
    {
        this.mod = inputMod;
    }
    
    /**
     * <p>Accessor to the middle node</p>
     * @return mod
     */
    public double GetMod()
    {
        return this.mod;
    }
    
    
}
