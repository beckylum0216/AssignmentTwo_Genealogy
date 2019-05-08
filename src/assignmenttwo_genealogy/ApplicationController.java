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
    private GraphDatabase treeDB = new GraphDatabase();
    
    public GraphDatabase GetTreeDB()
    {
        return this.treeDB;
    }
    
    public void SetTreeDB(GraphDatabase inputDB)
    {
        this.treeDB = inputDB;
    }
    
    
    
    
}
