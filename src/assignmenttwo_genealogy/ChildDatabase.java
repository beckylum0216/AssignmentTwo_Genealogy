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
    
    
    
    HashMap<String, Nodi> familyTree;
    
    public ChildDatabase()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        System.out.println("Tree manager size: " + this.familyTree.size());
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
        this.familyTree.put(inputNode.GetPersonID(), inputNode);        
    }
    
    public Nodi PeekNode(Nodi inputNode)
    {
        return this.familyTree.get(inputNode.GetPersonID());
    }
    
}
