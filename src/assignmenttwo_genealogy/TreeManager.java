/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author becky
 */
public class TreeManager {
    
    
    
    HashMap<String, Leaf> familyTree;
    
    public TreeManager()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        Leaf root = GetRootNode();
        familyTree.put(root.GetPersonID(), root);
        System.out.println("Tree manager size: " + this.familyTree.size());
    }
    
    public void SetFamilyTree(HashMap<String, Leaf> inputTree)
    {
        this.familyTree = inputTree;
    }
    
    public HashMap<String, Leaf> GetFamilyTree()
    {
        return this.familyTree;
    }
    
    public void AddNode(Leaf inputNode)
    {
        this.familyTree.put(inputNode.GetPersonID(), inputNode);        
    }
    
    public Leaf PeekNode(Leaf inputNode)
    {
        return this.familyTree.get(inputNode.GetPersonID());
    }
    
    public Leaf GetRootNode()
    {
        Leaf root = new Leaf();
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
