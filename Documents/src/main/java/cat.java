import java.awt.Image;

class Cat extends MovingEntity {
    Image catPic;
    Position currentCatPosition;

    public Cat(int x, int y) {
        super(x, y);
    }

    public void catchMouse(Position p) {

        

    }

    private void getBestMove(Position p) {
        /* LOGIC:
        If mouse is above cat, move cat up
        If mouse is below cat, move cat down
        If mouse is left of cat, move cat left
        If mouse is right of cat, move cat right
        Check for barriers at all times
        */

    }
}