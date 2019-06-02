package assignmenttwo_genealogy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import assignmenttwo_genealogy.MenuView;
import javafx.scene.Node;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.api.FxRobotInterface;
import org.testfx.api.FxRobot;
import org.hamcrest.Matchers;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

/**
 *
 * @author becky
 */
public class MenuViewTest extends ApplicationTest {
    
    MenuView newMenu;
    
    public MenuViewTest()
    {
        newMenu = new MenuView();
    }
    
    @Override
    public void init()
    {
        newMenu.init();
    }
    
    
    @Override
    public void start(Stage stage) throws Exception {
      stage.setScene(newMenu.GetScene());
      stage.show();
      stage.toFront();
    }
    
    @Test
    public void Test003_GridPane()
    {
        Node testNode = lookup("#menuNewPane").query();
        assertEquals("menuNewPane", testNode.getId());
    }
}
