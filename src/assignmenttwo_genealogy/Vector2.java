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
public class Vector2 {
    private double x;
    private double y;
    
    /**
     * <p>Parameterised constructor for the 2d vectors</p>
     * @param inputX X axis input
     * @param inputY Y axis input
     */
    public Vector2(double inputX, double inputY)
    {
        this.x = inputX;
        this.y = inputY;
    }
    
    /**
     * <p>Mutator to the x axis</p>
     * @param inputX x axis input
     */
    public void SetX(double inputX)
    {
        this.x = inputX;
    }
    
    /**
     * <p>Accessor to the X axis</p>
     * @return  x input x
     */
    public double GetX()
    {
        return this.x;
    }
    
    /**
     * <p>Mutator to the Y axis</p>
     * @param inputY Y input
     */
    public void SetY(double inputY)
    {
        this.y = inputY;
    }
    
    /**
     * <p>Accessor to the y axis</p>
     * @return input y
     */
    public double GetY()
    {
        return this.y;
    }
    
    /**
     * <p>Utility function to check if vectors are equal</p> 
     * @param targetVector the vector to be compared with 
     * @return boolean
     */
    public Boolean IsEqual(Vector2 targetVector)
    {
        if(this.x == targetVector.GetX() && this.y == targetVector.GetY())
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}
