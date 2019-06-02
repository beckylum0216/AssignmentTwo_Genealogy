/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit.ApplicationTest;

/**
 *
 * @author becky
 */
public class SaveViewTest extends ApplicationTest {
    
    public SaveViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        StackPane testPane = new StackPane();
        SaveView savePane = new SaveView(testPane);
        StackPane newPane = savePane.GetLoadPane();
        
        Scene newScene = new Scene(newPane, 100,100);
        stage.setScene(newScene);
        stage.show();
        stage.toFront();
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
    public void Test000_ButtonClick()
    {
        FxRobot bot = new FxRobot();
        Button testButton = lookup("#inputButton").queryButton();
        System.out.println(testButton.isVisible());
    }
    
    @Test
    public void Test003_GridPane()
    {
        Node testNode = lookup("#savePane").query();
        assertEquals("savePane", testNode.getId());
    }
}
