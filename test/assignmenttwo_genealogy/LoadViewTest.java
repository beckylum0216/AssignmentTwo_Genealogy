package assignmenttwo_genealogy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;


/**
 *
 * @author becky
 */
public class LoadViewTest extends ApplicationTest {
    
    public LoadViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        StackPane tempPane = new StackPane();
        LoadView inputPane = new LoadView(tempPane);
        StackPane newPane = inputPane.GetLoadPane();
        Scene newScene = new Scene(newPane, 100,100);
        stage.setScene(newScene);
        stage.show();
        stage.toFront();
    }
    
    @Test
    public void Test000_VMenu() 
    {
        Node testNode = lookup("#loadVMenu").query();
        assertEquals("loadVMenu", testNode.getId());
    }
}
