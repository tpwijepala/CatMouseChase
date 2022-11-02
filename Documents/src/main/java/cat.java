import java.awt.Image;

class Cat extends MovingEntity {
    private Image catPic;
    Position currentPosition;

    public Cat(int x, int y) {
        super(x, y);
    }

    public void catchMouse(Position p) {

        

    }

    private void getBestMove(Position p) {
        this.currentPosition = 
        /* LOGIC:
        Get cat's current position
        If mouse is above cat, move cat up
        If mouse is below cat, move cat down
        If mouse is left of cat, move cat left
        If mouse is right of cat, move cat right
        Check for barriers at all times
        */

    }
}