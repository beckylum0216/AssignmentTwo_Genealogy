/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 *
 * @author becky
 */
public class EditController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Button inputButton = (Button) event.getSource();
       
        if (inputButton.getText().equals("Edit"))
        {
            System.out.println("Edit");
            
        }
        else if(inputButton.getText().equals("Previous"))
        {
            System.out.println("Select previous");
        }
        else if(inputButton.getText().equals("Next"))
        {
            System.out.println("Select Next");
        }
    }
    
    
    
}
