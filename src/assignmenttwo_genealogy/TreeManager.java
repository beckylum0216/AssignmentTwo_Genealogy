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
    
    private static TreeManager treeDB = new TreeManager();
    
    HashMap<String, ArrayList<Leaf>> familyTree;
    
    private TreeManager()
    {
        System.out.println("Running Tree Manager constructor...");
        familyTree = new HashMap<>();
        Leaf root = GetRootNode();
        ArrayList <Leaf> rootList = new ArrayList<>();
        rootList.add(root);
        familyTree.put(root.GetParentOne(), rootList);
        System.out.println("Tree manager size: " + this.familyTree.size());
    }
    
    
    public static TreeManager GetInstance()
    {
        
        return treeDB;
    }
    
    public void SetFamilyTree(HashMap<String, ArrayList<Leaf>> inputTree)
    {
        this.familyTree = inputTree;
    }
    
    public HashMap<String, ArrayList<Leaf>> GetFamilyTree()
    {
        return this.familyTree;
    }
    
    public void AddNode(Leaf inputNode)
    {
        if(this.familyTree.containsKey(inputNode.GetParentOne()))
        {
            this.familyTree.get(inputNode.GetParentOne()).add(inputNode);
        }
        else
        {
            ArrayList <Leaf> inputList = new ArrayList<>();
            inputList.add(inputNode);
            this.familyTree.put(inputNode.GetParentOne(), inputList);
        }
        
    }
    
    public Leaf PeekNode(Leaf inputNode)
    {
        return this.familyTree.get(inputNode.GetParentOne()).get(this.familyTree.get(inputNode.GetParentOne()).indexOf(inputNode));
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
