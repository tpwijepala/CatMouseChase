package main.java;

public class MovingEntity extends Entity{

    public void move(Position newPos) {
        if (checkValidMove(newPos)) {
            map.moveCharacter(pos, newPos);
            pos = newPos;
        }
    }

    public boolean checkValidMove(Position newPos) {
        //  TO-DO:
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)
        if (Map.isWall(pos.x, pos.y) == 1) {
            return false;
        }
        return true;
    }
}
