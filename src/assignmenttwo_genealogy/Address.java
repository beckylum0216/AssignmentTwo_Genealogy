/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

/**
 *
 * @author becky
 */
public class Address {
    public String street;
    public String country;
    public String state;
    public int postcode;
    
    Address()
    {
        
    }
    
    Address(String inputStreet, String inputCountry, String inputState, int inputPostcode)
    {
        this.street = inputStreet;
        this.country = inputCountry;
        this.state = inputState;
        this.postcode = inputPostcode;
    }
    
    
}
