package assignmenttwo_genealogy;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import assignmenttwo_genealogy.MenuView;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.management.Query;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.api.FxRobot;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;
import org.testfx.service.query.NodeQuery;
import org.testfx.util.WaitForAsyncUtils;


/**
 *
 * @author becky
 */
public class InputViewTest extends ApplicationTest{
    
    
    
    public InputViewTest() {
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        InputView inputPane = new InputView();
        GridPane newPane = inputPane.SetInputPane();
        Scene newScene = new Scene(newPane, 100,100);
        stage.setScene(newScene);
        stage.show();
        stage.toFront();
    }
    
    @Test
    public void Test000_ButtonExists()
    {
        verifyThat(".button", hasText("Submit"));
    }
    
    @Test
    public void Test001_ButtonClick()
    {
        FxRobot bot = new FxRobot();
        Button testButton = lookup("#inputSubmit").queryButton();
        System.out.println(testButton.isVisible());
        
    }
    
    @Ignore
    public void Text002_Label()
    {
        Label testLabel = new Label();
        
        ArrayList <String> tempLabels = new ArrayList<>();
        tempLabels.add("Node ID:");
        tempLabels.add("First Name:");
        tempLabels.add("Last Name:");
        tempLabels.add("Married Last Name:");
        tempLabels.add("Gender:");
        tempLabels.add("Street Address:");
        tempLabels.add("Country:");
        tempLabels.add("State:");
        tempLabels.add("Postcode:");
        tempLabels.add("Blurb:");
        tempLabels.add("Parent 1:");
        tempLabels.add("Parent 2:");
        tempLabels.add("Spouse:");
        
        for(int ii = 0; ii < tempLabels.size(); ii += 0)
        {
            Node testNode;
            testNode = lookup("#"+tempLabels.get(ii)).query();
            assertEquals(tempLabels.get(ii), testNode.getId());
        }
        
    }
    
    @Test
    public void Test003_GridPane()
    {
        Node testNode = lookup("#inputNewPane").query();
        assertEquals("inputNewPane", testNode.getId());
    }
}
