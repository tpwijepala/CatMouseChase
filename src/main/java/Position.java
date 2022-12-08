
/**
 * Represents a location on the map using x and y coordinates
 * @author Robert Wilson
 * @version 1.0
 */
public class Position {
    protected int x;
    protected int y;

    /**
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return position's X-Coordinate
     */
    public int getX() {
        return x;
    }

    public void setX(int newX) {
        x = newX;
    }

    /**
     * @return position's Y-Coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * @param newY new Y-Coordinate
     */
    public void setY(int newY) {
        y = newY;
    }

    /**
     * @param newX new X-Coordinate
     * @param newY new Y-Coordinate
     */
    public void setPos(int newX, int newY) {
        setX(newX);
        setY(newY);
    }
}