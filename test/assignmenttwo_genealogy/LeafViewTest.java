/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author becky
 */
public class LeafViewTest extends ApplicationTest {
    
    public LeafViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Leaf testLeaf = new Leaf();
        LeafView leafPane = new LeafView(testLeaf);
        leafPane.AddLeafView();
        Label newPane = leafPane.GetLeafView();
        Scene newScene = new Scene(newPane, 100,100);
        stage.setScene(newScene);
        stage.show();
        stage.toFront();
    }
    
    @Test
    public void Test000_LeafLabel()
    {
        Node testNode = lookup("#LeafLabel").query();
        assertEquals("LeafLabel", testNode.getId());
    }
    
    
}
