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

    public boolean hit(MouseEvent event) {
        return upperLeft.getX() <= event.getX() && event.getX() <= maxX && upperLeft.getY() <= event.getY() && event.getY() <= maxY;
    }
    public void destroy(){
        this.height = 0;
        this.maxX = 0;
        this.maxY = 0;
        this.width = 0;
    }
}
