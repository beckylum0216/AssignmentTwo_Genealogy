/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author becky
 */
public class ApplicationController {
    private ChildDatabase treeDB = new ChildDatabase();
    
    private static ApplicationController newInstance = new ApplicationController();
    
    
     /**
     * <p>Singleton constructor for ChildDatabase, controls access.</P>
     */
    private ApplicationController()
    {}
    
    /**
     * <p>Singleton constructor for ChildDatabase, controls access.</P>
     * @return an static instance of Application controller
     */
    public static ApplicationController GetNewInstance()
    {
        return newInstance;
    }
    
    
    
    /**
     * <p>Accessor to the child database</P>
     * @return a hashtable of records 
     */
    public ChildDatabase GetTreeDB()
    {
        return this.treeDB;
    }
    
    /**
     * <p>Mutator to the child database</P>
     * @param inputDB database input
     */
    public void SetTreeDB(ChildDatabase inputDB)
    {
        this.treeDB = inputDB;
    }
    
    
    
    
}
