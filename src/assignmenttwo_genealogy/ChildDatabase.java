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
    
    public ChildDatabase()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        
    }
    
    public void SetFamilyTree(HashMap<String, Nodi> inputTree)
    {
        this.familyTree = inputTree;
    }
    
    public HashMap<String, Nodi> GetFamilyTree()
    {
        return this.familyTree;
    }
    
    public void AddNode(Nodi inputNode)
    {
        if(this.familyTree.isEmpty())
        {
            this.SetRootNode();
        }
        
        this.familyTree.put(inputNode.GetPersonID(), inputNode);        
    }
    
    public Nodi FindNode(Nodi inputNode)
    {
        return this.familyTree.get(inputNode.GetPersonID());
    }
    
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
    
    public Nodi GetRootNode()
    {
        return this.rootNode;
    }
    
}
