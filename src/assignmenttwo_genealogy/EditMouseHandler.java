/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author becky
 */
public class EditMouseHandler implements EventHandler<MouseEvent> 
{
    private ListView newList;
    private TextField[] inputFields;
    private Nodi currentRecord;
    
    
    /**
     * <p> constructor for the mouse event handler</P>
     * @param inputView the list to the ListView
     * @param targetFields the input fields on the edit form
     */
    public EditMouseHandler(ListView inputView, TextField[] targetFields)
    {
        this.newList = inputView;
        this.inputFields = targetFields;
    }
    
    /**
     * <p> Event Handler specific to the mouse events and set current record</P>
     * @param mouse event variable for the mouse 
     */
    @Override
    public void handle(MouseEvent mouse)
    {
        String recordID = newList.getSelectionModel().getSelectedItem().toString();
        currentRecord = ApplicationController.GetNewInstance().GetTreeDB().GetFamilyTree().get(recordID);
        inputFields[0].setText(currentRecord.GetPersonID());
        inputFields[1].setText(currentRecord.GetFirstName());
        inputFields[2].setText(currentRecord.GetLastNameBirth());
        inputFields[3].setText(currentRecord.GetLastNameMarraige());
        inputFields[4].setText(currentRecord.GetPersonGender());
        inputFields[5].setText(currentRecord.GetPersonAddress().street);
        inputFields[6].setText(currentRecord.GetPersonAddress().country);
        inputFields[7].setText(currentRecord.GetPersonAddress().state);
        inputFields[8].setText(String.valueOf(currentRecord.GetPersonAddress().postcode));
        inputFields[9].setText(currentRecord.GetPersonBlurb());
        inputFields[10].setText(currentRecord.GetParentOne());
        inputFields[11].setText(currentRecord.GetParentTwo());
        inputFields[12].setText(currentRecord.GetPersonSpouse());
    }
    
    /**
     * <p> Accessor to the current record being edited</P>
     * @return currentRecord 
     */
    public Nodi GetCurrentRecord()
    {
        return this.currentRecord;
    }
    
}
