package presentation;

public class Point {

    private int x;
    private int y;

    /**
     * point is used as an offset for all clickale fields.
     * <p> A point will have an x and y coordinate, this is used by clickable fields to check wether a click was inside the desired area or not.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x-axis coordinate
     */
    public int getX() {
        return x;
    }

     /**
     * @return y-axis coordinate
     */
    public int getY() {
        return y;
    }
}
