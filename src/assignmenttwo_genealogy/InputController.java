/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author becky
 */
public class InputController implements EventHandler<ActionEvent>
{
    TextField[] detailsField;
    
    public InputController(TextField[] inputField)
    {
       
        this.detailsField = inputField;
    }
    
    @Override
    public void handle(ActionEvent event) 
    {
        Leaf tempNode = new Leaf();
        tempNode.SetPersonID(detailsField[0].getText());
        tempNode.SetFirstName(detailsField[1].getText());
        tempNode.SetLastNameBirth(detailsField[2].getText());
        tempNode.SetLastNameMarraige(detailsField[3].getText());
        tempNode.SetPersonGender(detailsField[4].getText());
        tempNode.GetPersonAddress().street = detailsField[5].getText();
        tempNode.GetPersonAddress().country = detailsField[6].getText();
        tempNode.GetPersonAddress().state = detailsField[7].getText();
        tempNode.GetPersonAddress().postcode = Integer.parseInt(detailsField[8].getText());
        tempNode.SetPersonBlurb(detailsField[9].getText());
        tempNode.SetParentOne(detailsField[10].getText());
        tempNode.SetParentTwo(detailsField[11].getText());
        tempNode.SetPersonSpouse(detailsField[12].getText());
        TreeManager.GetInstance().AddNode(tempNode);
        //TreeManager.GetInstance().PeekNode(tempNode).PrintNode();
        
    }
    
    
    
    
}
