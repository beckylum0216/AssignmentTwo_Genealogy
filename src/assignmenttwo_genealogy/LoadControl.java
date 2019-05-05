/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 *
 * @author becky
 */
public class LoadControl implements EventHandler<ActionEvent>, Serializable {
    
    TextField pathField;
    
    LoadControl(TextField inputField)
    {
        pathField = inputField;
    }
    
    @Override
    public void handle(ActionEvent event) {
        String filePath = pathField.getText();
        
        
        
    }
    
    /**
    * <p> Utility function retrieving records from files</p>
    * @param filePath the file path to get data from a csv file, must not have spaces
    * @return customerRecords record list
    * @since 1.0
    */
    public List<List<String>> CSVFileReader(String filePath)
    {
        List<List<String>> customerRecords = new ArrayList<>();
        try 
        {
            FileReader targetFile = new FileReader(filePath);
            BufferedReader br = new BufferedReader(targetFile);
            
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] values = line.split(",");
                customerRecords.add(Arrays.asList(values));
                
            }
            
            targetFile.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        
        return customerRecords;
    }
    
}
