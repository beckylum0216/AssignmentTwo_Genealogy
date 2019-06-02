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
public class EditViewTest extends ApplicationTest {
    
    public EditViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        EditView editPane = new EditView();
        GridPane newPane = editPane.SetEditPane();
        
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
        Button testButton = lookup("#editButton").queryButton();
        System.out.println(testButton.isVisible());
    }
    
    @Test
    public void Test003_GridPane()
    {
        Node testNode = lookup("#EditPane").query();
        assertEquals("EditPane", testNode.getId());
    }
}
