
public class MovingEntity extends Entity{
    Map map;
    public MovingEntity(int x, int y, Map m) {
        super(x, y);
        map = m;
    }

    public void move(Position newPos) {
        if (checkValidMove(newPos)) {
            this.setPos(newPos.getX(), newPos.getY());

        }
    }

    /**
    * Returns a boolean 
    */
    public boolean checkValidMove(Position newPos) {
        if (newPos.getX() < 0 || newPos.getY() < 0 || newPos.getX() > 57 || newPos.getY() > 41) {
            return false;
        }

        else if (map.isWall(newPos.getX(), newPos.getY()) == 1) {
            return false;
        }

        //  TO-DO:
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)

        return true;
    }
}
