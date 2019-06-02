/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author becky
 */
public class LeafTest {
    
    public LeafTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void Test000_Leaf()
    {
        Leaf testLeaf = new Leaf();
        return;
                
    }
    
    @Test
    public void Test001_Equal()
    {
        Leaf testLeafOne = new Leaf();
        Leaf testLeafTwo = new Leaf();
        
        assertEquals(true, testLeafOne.IsEqual(testLeafTwo));
        
    }
}
