import javax.imageio.ImageIO;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
//import java.util.Queue;
//import java.util.LinkedList;

/**
 * @author Karina Kramer
 * @version 1.0
 */
class Cat extends MovingEntity {
    Position currentPosition;

    /**
     * Instantiates this cat's position and its image on 
     * the game map
     * @param x     Row coordinate on map
     * @param y     Column coordinate on map
     */
    public Cat(int x, int y) {
        super(x, y);

        try{
            picture = ImageIO.read(new File("src/main/resources/cat.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Triggers the cats on the map to begin moving towards
     * the mouse by passing the mouse's current position into
     * catchMouse
     * <p>
     * This method is called only when the user presses a valid
     * input key for the first time
     * 
     * @param mousePos  Mouse's current position after key press
     */
    public void startMove(Position mousePos) {
        //Add tick method here

        catchMouse(mousePos);
    }

    /**
     * Moves the cat into its next cell that is closest
     * to the mouse. Calls on MovingEntity move method 
     * to update position and checks to see if this cat
     * intersects with the mouse, at which point it will
     * trigger the end of the game and the player loses.
     * @param p
     */
    public void catchMouse(Position p) {

        Position nextMove = getBestMove(p);

        move(nextMove);
        
        if (nextMove.getX() == p.getX() && nextMove.getY() == p.getY()) {
            Game.State = Game.STATE.LOSE;
            return;
        }

    }
    

    /**
     * Returns the Position of where the cat should move next given
     * the mouse's current position. Checks if the next move intersects
     * another cat, in which case an alternative move is generated.
     * Barrier checks are done in MovingEntities's move method 
     *  another cat in the way, in which case
     * an alternative move is generated. If the move intersects a mouse trap, 
     * cheese, or crumb, it is treated as a regular cell.
     * <p>
     * This method returns every second regardless if the mouse has 
     * moved or not after the initial move.
     * 
     * @param p     Mouse's current position after keyboard input
     * @return      Position the move to that is closest to the Mouse
     */
    private Position getBestMove(Position p) {
        int moveUp = 0;
        int moveDown = 0;
        int moveRight = 0;
        int moveLeft = 0;
        currentPosition = getPos();
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

        //Check for any other cats

        //Develop the rest of this code here
        return nextPosition;

    }

} 