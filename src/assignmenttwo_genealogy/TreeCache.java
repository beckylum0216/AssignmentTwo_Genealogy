/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author becky
 */
public class TreeCache {
    
    ApplicationController appControl;
    Leaf root;
    
    
    
    TreeCache()
    {
        appControl = new ApplicationController();
        Nodi tempRoot = appControl.GetTreeDB().GetRootNode();
        root = new Leaf(tempRoot);
    }
    
    public void PopulateCache()
    {
        HashMap <String, String> parentMap = new HashMap <>();
        HashMap <String, Leaf> parentLeafMap = new HashMap<>();
        
        for(Map.Entry nodePair:this.appControl.GetTreeDB().familyTree.entrySet())
        {
            Nodi tempNode = (Nodi) nodePair.getValue();
            
            if(!parentMap.containsKey(tempNode.GetParentOne()))
            {
               parentMap.put(tempNode.GetParentOne(), tempNode.GetParentOne());
            }
            
        }
        
        for(Map.Entry parentPair: parentLeafMap.entrySet())
        {
            String parentName = (String) parentPair.getKey();
            Nodi parentNode = this.appControl.GetTreeDB().familyTree.get(parentName);
            Leaf parentLeaf = new Leaf(parentNode);
            parentLeafMap.put(parentName, parentLeaf);
        }
        
        for(Map.Entry inputPair: this.appControl.GetTreeDB().familyTree.entrySet())
        {
            Nodi childNode = (Nodi) inputPair.getValue();
            Leaf childLeaf = new Leaf(childNode);
            
            if(parentMap.containsKey(childNode.GetParentOne()))
            {
                parentLeafMap.get(childNode.GetParentOne()).AddChild(childLeaf);
            }
            
        }
        
        
    }
    
    
}
