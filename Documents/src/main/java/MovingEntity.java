public class MovingEntity extends Entity{

    public MovingEntity(Position p) {
        super();
    }

    public void move(Position newPos) {
        pos = newPos;

        if (checkValidMove(newPos)) {
            // TO-DO:
            //   Move entity's position on characters 2D array in Map class
        }

    }

    public boolean checkValidMove(Position newPos) {
        if (isWall(newPos.getX(), newPos.getY())) {
            return false;
        }

        else if ()
        //  TO-DO:
        //    if newPos intersects the walls array:  return false
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)
        return true;
    }
}
