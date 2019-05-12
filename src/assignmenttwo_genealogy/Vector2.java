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
    
    public Vector2(double inputX, double inputY)
    {
        this.x = inputX;
        this.y = inputY;
    }
    
    public void SetX(double inputX)
    {
        this.x = inputX;
    }
    
    public double GetX()
    {
        return this.x;
    }
    
    public void SetY(double inputY)
    {
        this.y = inputY;
    }
    
    public double GetY()
    {
        return this.y;
    }
    
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
