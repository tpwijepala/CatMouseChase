//package main.java;

public class MovingEntity extends Entity{
    //Position pos;

    public MovingEntity(int x, int y) {
        super(x, y);
    }

    public void move(Position newPos) {
        Map map = new Map();
        if (checkValidMove(newPos)) {
            map.moveCharacter(this.getPos(), newPos);
            //pos = newPos;
            this.setPos(newPos.getX(), newPos.getY());

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
