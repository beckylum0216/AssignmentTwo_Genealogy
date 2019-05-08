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

public class Nodi implements Serializable{
    private String personID;
    private String firstName;
    private String lastNameBirth;
    private String lastNameMarriage;
    private String personGender;
    private Address personAddress;
    private String personBlurb;
    private String parentOne;
    private String parentTwo;
    private String personSpouse;
    
    
    
    Nodi()
    {
        personAddress = new Address();
    }
    
    Nodi(Nodi inputNode)
    {
        this.personID = inputNode.personID;
        this.firstName = inputNode.firstName;
        this.lastNameBirth = inputNode.lastNameBirth;
        this.lastNameMarriage = inputNode.lastNameMarriage;
        this.personGender = inputNode.personGender;
        this.personAddress = inputNode.personAddress;
        this.personBlurb = inputNode.personBlurb;
        this.parentOne = inputNode.parentOne;
        this.parentTwo = inputNode.parentTwo;
        this.personSpouse = inputNode.personSpouse;
    }
    
    
     public void SetPersonID(String inputID)
     {
         this.personID = inputID;
     }
     
     public String GetPersonID()
     {
         return this.personID;
     }
     
     public void SetFirstName(String inputFirstName)
     {
         this.firstName = inputFirstName;
     }
     
     public String GetFirstName()
     {
         return this.firstName;
     }
     
     public void SetLastNameBirth(String inputLastName)
     {
         this.lastNameBirth = inputLastName;
     }
     
     public String GetLastNameBirth()
     {
         return this.lastNameBirth;
     }
     
     
    public void SetLastNameMarraige(String inputLastName)
    {
        this.lastNameMarriage = inputLastName;
    }
    
    public String GetLastNameMarraige()
    {
        return this.lastNameMarriage;
    }
    
    public void SetPersonGender(String inputGender)
    {
        this.personGender = inputGender;
    }
    
    public String GetPersonGender()
    {
        return this.personGender;
    }
    
    public void SetPersonAddress(Address inputAddress)
    {
        this.personAddress = inputAddress;
    }
    
    public Address GetPersonAddress()
    {
        return this.personAddress;
    }
    
    public void SetPersonBlurb(String inputBlurb)
    {
        this.personBlurb = inputBlurb;
    }
    public String GetPersonBlurb()
    {
        return this.personBlurb;
    }
    
    public void SetParentOne(String inputParent)
    {
        this.parentOne = inputParent;
    }
    
    public String GetParentOne()
    {
        return this.parentOne;
    }
    
    public void SetParentTwo(String inputParent)
    {
        this.parentTwo = inputParent;
    }
    
    public String GetParentTwo()
    {
        return this.parentTwo;
    }
    
    public void SetPersonSpouse(String inputSpouse)
    {
        this.personSpouse = inputSpouse;
    }
    
    public String GetPersonSpouse()
    {
        return this.personSpouse;
    }
    
    public void PrintNode()
    {
        System.out.println("Person ID: " + this.personID);
        System.out.println("First Name: " + this.firstName);
        System.out.println("Last Name: " + this.lastNameBirth);
        System.out.println("Last Name Marriage: " + this.lastNameMarriage);
        System.out.println("Gender: " + this.personGender);
        System.out.println("Street: " + this.personAddress.street);
        System.out.println("Country: " + this.personAddress.country);
        System.out.println("State: "+ this.personAddress.state);
        System.out.println("Postcode: " + this.personAddress.postcode);
        System.out.println("Blurb: " + this.personBlurb);
        System.out.println("ParentOne: " + this.parentOne);
        System.out.println("ParentTwo: " + this.parentTwo);
        System.out.println("Spouse: " + this.personSpouse);
    }
    
}
