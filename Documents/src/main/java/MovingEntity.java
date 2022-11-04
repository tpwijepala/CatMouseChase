public class MovingEntity extends Entity{
    public MovingEntity(int x, int y){
        super(x, y);
    }

    public void move(Position newPos) {
        pos = newPos;

        if (checkValidMove(newPos)) {
            // TO-DO:
            //   Move entity's position on characters 2D array in Map class
        }

    }

    public boolean checkValidMove(Position newPos) {
        //  TO-DO:
        //    if newPos intersects the walls array:  return false
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)
        return true;
    }
}
