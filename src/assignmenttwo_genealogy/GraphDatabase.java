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
public class GraphDatabase implements Serializable{
    
    
    
    HashMap<String, Nodi> familyTree;
    
    public GraphDatabase()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        Nodi root = GetRootNode();
        familyTree.put(root.GetPersonID(), root);
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
    
    public Nodi GetRootNode()
    {
        Nodi root = new Nodi();
        root.SetPersonID("root001");
        root.SetFirstName("root");
        root.SetLastNameBirth("root");
        root.SetLastNameMarraige("root");
        root.SetPersonGender("root");
        Address rootAddress = new Address();
        rootAddress.street = "root";
        rootAddress.country = "root";
        rootAddress.postcode = 12345;
        rootAddress.state = "root";
        root.SetPersonAddress(rootAddress);
        root.SetPersonBlurb("root");
        root.SetParentOne("root");
        root.SetParentTwo("root");
        root.SetPersonSpouse("root");
        
        return root;
    }
    
    
    
}
