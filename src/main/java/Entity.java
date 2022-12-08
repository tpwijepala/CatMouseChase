import java.awt.*;

public class Entity {
    Position pos;
    Map map;
    Image picture;

    /**
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
