/**
 * Controls common operations for Mouse and Cat objects
 */
public class MovingEntity extends Entity {
    
    public MovingEntity(int x, int y, Map m) {
        super(x, y);
        map = m;
    }

    public void move(Position newPos) {
        if (checkValidMove(newPos)) {
            pos.setPos(newPos.getX(), newPos.getY());
        }
    }

    /**
     * Checks if a wall is preventing movement into a new position 
     * or if the anticipated move goes outside the Map's boundaries.
     * 
     * @param newPos Position the entity is moving to
     * @return boolean value of the move's validity
     */
    public boolean checkValidMove(Position newPos) {
        if (newPos.getX() < 0 || newPos.getY() < 0 || newPos.getX() > 57 || newPos.getY() > 41) {
            return false;
        }

        else if (map.isWall(newPos.getX(), newPos.getY()) == 1) {
            return false;
        }

        return true;
    }
}
