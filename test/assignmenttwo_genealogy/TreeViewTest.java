/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
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
public class TreeViewTest extends ApplicationTest{
    
    public TreeViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        TreeView testView = new TreeView();
        
        Pane newPane = testView.SetTreePane();
        
        Scene newScene = new Scene(newPane, 100,100);
        stage.setScene(newScene);
        stage.show();
        stage.toFront();
    }
    
    
    @Test
    public void Test003_Pane()
    {
        Node testNode = lookup("#treePane").query();
        assertEquals("treePane", testNode.getId());
    }
}
