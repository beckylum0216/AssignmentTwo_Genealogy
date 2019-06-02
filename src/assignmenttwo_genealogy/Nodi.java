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
    
    
    /**
     * <p>Default constructor for a node </p>
     */
    Nodi()
    {
        personAddress = new Address();
    }
    
    /**
     * <p> parameterised constructor for a child node</p>
     * @param inputNode 
     */
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
    
    /**
     * <p> Accessor for the Person Id </p>
     * @param inputID ID input
     */
    public void SetPersonID(String inputID)
    {
        this.personID = inputID;
    }

    /**
     * <p>Accessor to the node ID </p>
     * @return personID the node's id
     */
    public String GetPersonID()
    {
        return this.personID;
    }
    
    /**
     * <p> Mutator to the firstNsme field</p>
     * @param inputFirstName first name input
     */
    public void SetFirstName(String inputFirstName)
    {
        this.firstName = inputFirstName;
    }
    
    /**
     * <p>Accessor to the firstnaame field </p>
     * @return firstName first name input
     */
    public String GetFirstName()
    {
        return this.firstName;
    }
    
    /**
     * <p>Mutator to the last name field </p>
     * @param inputLastName last name input
     */
    public void SetLastNameBirth(String inputLastName)
    {
        this.lastNameBirth = inputLastName;
    }
    
    /**
     * <p>Accessor to the last name field</p>
     * @return lastNameBirth input
     */
    public String GetLastNameBirth()
    {
        return this.lastNameBirth;
    }
     
    /**
     * <p>Mutator to the last name field after marriage</p>
     * @param inputLastName last name input
     */
    public void SetLastNameMarraige(String inputLastName)
    {
        this.lastNameMarriage = inputLastName;
    }
    
    /**
     * <p>Accessor to the last name field after marriage</p>
     * @return lastNameMarriage
     */
    public String GetLastNameMarraige()
    {
        return this.lastNameMarriage;
    }
    
    /**
     * <p>Mutator to the gender field</p>
     * @param inputGender gender input
     */
    public void SetPersonGender(String inputGender)
    {
        this.personGender = inputGender;
    }
    
    /**
     * <p>Accessor to the gender field</P>
     * @return personGender the gender
     */
    public String GetPersonGender()
    {
        return this.personGender;
    }
    
    /**
     * <p>Mutator to the address field</P>
     * @param inputAddress address class input a struct really
     */
    public void SetPersonAddress(Address inputAddress)
    {
        this.personAddress = inputAddress;
    }
    
    /**
     * <p>Accessor to the address field</p>
     * @return personAddress
     */
    public Address GetPersonAddress()
    {
        return this.personAddress;
    }
    
    /**
     * <p>Mutator to the blurb field</P>
     * @param inputBlurb the blurb input
     */
    public void SetPersonBlurb(String inputBlurb)
    {
        this.personBlurb = inputBlurb;
    }
    
    /**
     * <p>Accessor to the blurb field</p>
     * @return personBlurb
     */
    public String GetPersonBlurb()
    {
        return this.personBlurb;
    }
    
    /**
     * <p>Mutator to the parent one field</p>
     * @param inputParent parent input
     */
    public void SetParentOne(String inputParent)
    {
        this.parentOne = inputParent;
    }
    
    /**
     * <p>Accessor to the parent one field</p>
     * @return parentOne primary parent
     */
    public String GetParentOne()
    {
        return this.parentOne;
    }
    
    /**
     * <p>Mutator to the other parent</p>
     * @param inputParent parent input
     */
    public void SetParentTwo(String inputParent)
    {
        this.parentTwo = inputParent;
    }
    
    /**
     * <p>Accessor to the other parent field</p>
     * @return parentTwo input
     */
    public String GetParentTwo()
    {
        return this.parentTwo;
    }
    
    /**
     * <p>Mutator to the spouse field </P>
     * @param inputSpouse spouse input
     */
    public void SetPersonSpouse(String inputSpouse)
    {
        this.personSpouse = inputSpouse;
    }
    
    /**
     * <p> Acccessor to the spouse field</P>
     * @return personSpouse 
     */
    public String GetPersonSpouse()
    {
        return this.personSpouse;
    }
    
    /**
     * <p>Utility function printing the contents of the node</p>
     */
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
