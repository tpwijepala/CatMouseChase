/**
 * Represents a location on the map using x and y coordinates
 * @author Robert Wilson
 * @version 1.0
 */
public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }

    public int getY() {
        return y;
    }

    public void setY(int newY) {
        y = newY;
    }

    /**
     * Used when both x and y coordinates change
     * 
     * @param newX new X-Coordinate
     * @param newY new Y-Coordinate
     */
    public void setPos(int newX, int newY) {
        setX(newX);
        setY(newY);
    }
}