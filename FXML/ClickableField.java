/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prettywomanfx;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author Obel
 */
public class ClickableField
{
    private Point upperLeft;
    private int height;
    private int width;
    private int maxX;
    private int maxY;
    public ClickableField(Point upperLeft, int height, int width)
    {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.maxX = upperLeft.getX() + this.width;
        this.maxY = upperLeft.getY() + this.height;
        
    }
    public boolean hit(MouseEvent event)
    {
        System.out.println("1111");
        System.out.println(upperLeft.getX() <= event.getX() && event.getX() <= maxX && upperLeft.getY() <= event.getY() && event.getY() <= maxY);
        return upperLeft.getX() <= event.getX() && event.getX() <= maxX && upperLeft.getY() <= event.getY() && event.getY() <= maxY;
    }
}
