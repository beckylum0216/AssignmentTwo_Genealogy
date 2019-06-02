/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author becky
 */
public class ChildDatabase implements Serializable{
    
    
    private Nodi rootNode;
    private HashMap<String, Nodi> familyTree;
    
    
    /**
     * <p>Default constructor to the child database</P>
     */
    public ChildDatabase()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        
    }
    
    /**
     * <p>Sets a copy of the database into the program</P>
     * @param inputTree tree input
     */
    public void SetFamilyTree(HashMap<String, Nodi> inputTree)
    {
        this.familyTree = inputTree;
    }
    
    /**
     * <p>Accessor to get the local copy of the family database</P>
     * @return familyTree 
     */
    public HashMap<String, Nodi> GetFamilyTree()
    {
        return this.familyTree;
    }
    
    /**
     * <p>Mutator to the familyTree database. Adds one record</P>
     * @param inputNode record containing the  
     */
    public void AddNode(Nodi inputNode)
    {
        if(this.familyTree.isEmpty())
        {
            this.SetRootNode();
        }
        
        this.familyTree.put(inputNode.GetPersonID(), inputNode);        
    }
    
    /**
     * <p> accessor to the familyTree database. Finds specific record</P>
     * @param inputNode target record to retrieve
     * @return targetNode based on the personID
     */
    public Nodi FindNode(Nodi inputNode)
    {
        return this.familyTree.get(inputNode.GetPersonID());
    }
    
    /**
     * <p> accessor to the familyTree database. Finds specific record</P>
     * @param inputNode target record to retrieve
     * @return targetNode based on the personID
     */
    public Nodi FindNode(String inputString)
    {
        return this.familyTree.get(inputString);
    }
    
    
    /**
     * <p> mutator to the family database. Creates a root record for all records to connect to</P>
     */
    private void SetRootNode()
    {
        rootNode = new Nodi();
        rootNode.SetPersonID("root001");
        rootNode.SetFirstName("root001");
        rootNode.SetLastNameBirth("root001");
        rootNode.SetLastNameMarraige("root001");
        rootNode.SetParentOne("root001");
        this.familyTree.put(rootNode.GetPersonID(), rootNode);
    }
    
    /**
     * <p>Accessor to the root node </P>
     * @return rootNode the root node
     */
    public Nodi GetRootNode()
    {
        return this.rootNode;
    }
    
}
