import java.awt.*;

/**
 * Parent Class for all Static and Moving Entities on Map
 */
public class Entity {
    Position pos;
    Map map;
    Image picture;

    /**
     * Gives any entity, besides barriers, on the board a position
     * 
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public Entity(int x, int y){
        pos = new Position(x, y);
    }

    public Position getPos() {
        return pos;
    }

    /**
     * Draws this entity onto the game's window
     * 
     * @param g Graphics object handling the game's UI
     * @see Graphics
     */
    public void draw(Graphics g) {
        g.drawImage(picture, pos.getX() * Map.CELLWIDTH, pos.getY() * Map.CELLWIDTH, null);
    }

}
