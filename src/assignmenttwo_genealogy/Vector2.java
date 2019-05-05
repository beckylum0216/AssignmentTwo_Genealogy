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
    private int x;
    private int y;
    
    Vector2(int inputX, int inputY)
    {
        this.x = inputX;
        this.y = inputY;
    }
    
    public void SetX(int inputX)
    {
        this.x = inputX;
    }
    
    public int GetX()
    {
        return this.x;
    }
    
    public void SetY(int inputY)
    {
        this.y = inputY;
    }
    
    public int GetY()
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
