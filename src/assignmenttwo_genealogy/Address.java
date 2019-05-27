/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenttwo_genealogy;

import java.io.Serializable;

/**
 *
 * @author becky
 */
public class Address implements Serializable{
    public String street;
    public String country;
    public String state;
    public int postcode;
    
    
    /**
     * <p>Default constructor for address. This is really a struct</P>
     */
    Address()
    {
        
    }
    
    
    /**
     * <p>Parameterised constructor for address</P>
     */
    Address(String inputStreet, String inputCountry, String inputState, int inputPostcode)
    {
        this.street = inputStreet;
        this.country = inputCountry;
        this.state = inputState;
        this.postcode = inputPostcode;
    }
    
    
}
