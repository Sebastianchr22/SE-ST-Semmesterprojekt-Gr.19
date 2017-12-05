package presentation;

import javafx.scene.input.MouseEvent;

public class ClickableField {

    private Point upperLeft;
    private int height;
    private int width;
    private int maxX;
    private int maxY;

    public ClickableField(Point upperLeft, int height, int width) {
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
        this.maxX = upperLeft.getX() + this.width;
        this.maxY = upperLeft.getY() + this.height;

    }

    /**
     * This method is used to see if a click was inside the given area of the field.
     * <p> this is done by checking if the click x-axis coordinate is larger than the x-axis offset. If the click's x-axis coordinate is less than the maxX(x-axis 
     * offset + width).And if the click's y-axis coordinate is larger than the y-axis offset. And if the click's y-axis coordinate is less than the maxY (y-axis
     * offset + height).
     * <p> if all that is true, then this method will return true.
     * @param event given by a mouse click, calling this method.
     * @return boolean
     */
    public boolean hit(MouseEvent event) {
        return upperLeft.getX() <= event.getX() && event.getX() <= maxX && upperLeft.getY() <= event.getY() && event.getY() <= maxY;
    }
    
    /**
     * This method is used in the Controller class, to completely undo a clickable field, as this will make them un-clickable.
     * <p> this is a complete undoing of the field, by setting both offsets, height, and width to 0.
     */
    public void destroy(){
        this.height = 0;
        this.maxX = 0;
        this.maxY = 0;
        this.width = 0;
    }
}
