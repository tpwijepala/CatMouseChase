package main.java;

public class MovingEntity extends Entity{

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
