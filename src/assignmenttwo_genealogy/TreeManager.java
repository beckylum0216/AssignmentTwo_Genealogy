/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.HashMap;

/**
 *
 * @author becky
 */
public class TreeManager {
    HashMap<String, Leaf> familyTree;
    
    public TreeManager()
    {
        familyTree = new HashMap<>();
    }
    
    public void SetFamilyTree(HashMap<String, Leaf> inputTree)
    {
        this.familyTree = inputTree;
    }
    
    public HashMap<String, Leaf> GetFamilyTree()
    {
        return this.familyTree;
    }
    
    public void AddeNode(Leaf inputNode)
    {
        this.familyTree.put(inputNode.GetPersonID(), inputNode);
    }
    
    public Leaf PeekNode(String inputID)
    {
        return this.familyTree.get(inputID);
    }
    
    
    
}
