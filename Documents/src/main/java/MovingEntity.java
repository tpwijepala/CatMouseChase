//package main.java;

public class MovingEntity extends Entity{
    Position pos;

    public MovingEntity(int mEX, int mEY) {
        super(mEX, mEY);
    }

    public void move(Position newPos) {
        if (checkValidMove(newPos)) {
            map.moveCharacter(pos, newPos);
            pos = newPos;

        }
    }

    /**
    * Returns a boolean 
     */
    public boolean checkValidMove(Position newPos) {
        if (Map.isWall(newPos.getX(), newPos.getY()) == 1) {
            return false;
        }
        //  TO-DO:
        //    if newPos intersects a cat in characters array:  trigger catchMouse() and return false(?)

        return true;
    }
}
