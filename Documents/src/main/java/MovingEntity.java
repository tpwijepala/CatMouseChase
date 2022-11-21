
/**
 * @author Robert Wilson
 * @version 1.0
 */
public class MovingEntity extends Entity{

    /**
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public MovingEntity(int x, int y) {
        super(x, y);
    }

    /**
     * Moves this entity into a new position. If the move is valid,
     * this entity's position is updated to its new location and its
     * location within the map is updated.
     * @param newPos Position this entity is moving to
     * @see Map
     */
    public void move(Position newPos) {
        Map map = new Map();
        
        if (checkValidMove(newPos)) {
            map.moveCharacter(this.getPos(), newPos);
            this.setPos(newPos.getX(), newPos.getY());

        }
    }

    /**
     * Checks if a wall is preventing movement into a new position.
     * @param newPos Position the entity is moving to
     * @return boolean value of the move's validity
     */
    public boolean checkValidMove(Position newPos) {
        if (newPos.getX() < 0 || newPos.getY() < 0 || newPos.getX() > 57 || newPos.getY() > 41) {
            return false;
        }

        else if (Map.isWall(newPos.getX(), newPos.getY()) == 1) {
            return false;
        }

        //  TO-DO:
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)

        return true;
    }
}
