import java.awt.Image;

class Cat extends MovingEntity {
    private Image catPic;
    Position currentPosition;

    public Cat(int x, int y) {
        super(x, y);
    }

    //p will probably be mouse's current position
    public void catchMouse(Position p) {
        Position nextMove = getBestMove(p);
        
        if (nextMove.getX() == p.getX() && nextMove.getY() == p.getY()) {
            //return LOSE;
            return;
        }

    }

    private Position getBestMove(Position p) {
        int moveUp = 0;
        int moveDown = 0;
        int moveRight = 0;
        int moveLeft = 0;
        Position currentPosition = this.pos;
        Position nextPosition = new Position(currentPosition.getX(), currentPosition.getY());

        //Check where the mouse is in proximity to cat
        if (currentPosition.getY() < p.getY()) {
            moveUp = currentPosition.getY() + 1;
            nextPosition.setY(moveUp);
        }

        else if (currentPosition.getY() > p.getY()) {
            moveDown = currentPosition.getY() - 1;
            nextPosition.setY(moveDown);
        }
        
        else if (currentPosition.getX() < p.getX()) {
            moveRight = currentPosition.getX() + 1;
            nextPosition.setX(moveRight);
        }

        else {
            moveLeft = currentPosition.getX() - 1;
            nextPosition.setX(moveLeft);
        }

        //Check for barriers
        if (this.checkValidMove(nextPosition)) {
            currentPosition = nextPosition;
        }

        //Check for any other cats
        //Develop the rest of this code here

        return currentPosition;

    }
}