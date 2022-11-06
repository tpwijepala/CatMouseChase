import javax.imageio.ImageIO;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
//import java.util.Queue;
//import java.util.LinkedList;

/**
 * Author: Karina Kramer
 * Version: 1.0
 */
class Cat extends MovingEntity {
    Position currentPosition;

    /**
     * 
     * @param x
     * @param y
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

    //NOTE: This is the attempt to implement a Breadth First Search algorithm to get a better move for the cat than the
    //      move in the above functions
    /*
    public void catchMouse(Position mousePosition) {

        int depth = 1;
        int miniRows = 5;
        int miniCols = 5;
        int cPX = getPos().getX();
        int cPY = getPos().getY();
        int nodesCurrentLayer = 1;
        int nodesNextLayer = 0;
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};
        int[][] miniMap = {{Map.isWall(cPX - 2, cPY - 2), Map.isWall(cPX - 1, cPY - 2), Map.isWall(cPX, cPY - 2), Map.isWall(cPX + 1, cPY - 2), Map.isWall(cPX + 2, cPY - 2)},
                           {Map.isWall(cPX - 2, cPY - 1), Map.isWall(cPX - 1, cPY - 1), Map.isWall(cPX, cPY - 1), Map.isWall(cPX + 1, cPY - 1), Map.isWall(cPX + 2, cPY - 1)},
                           {Map.isWall(cPX - 2, cPY), Map.isWall(cPX - 1, cPY), Map.isWall(cPX, cPY), Map.isWall(cPX + 1, cPY), Map.isWall(cPX + 2, cPY)},
                           {Map.isWall(cPX - 2, cPY + 1), Map.isWall(cPX - 1, cPY + 1), Map.isWall(cPX, cPY + 1), Map.isWall(cPX + 1, cPY + 1), Map.isWall(cPX + 2, cPY + 1)},
                           {Map.isWall(cPX - 2, cPY + 2), Map.isWall(cPX - 1, cPY + 2), Map.isWall(cPX, cPY + 2), Map.isWall(cPX + 1, cPY + 2), Map.isWall(cPX + 2, cPY + 2)}};

        Queue<Integer> moveTrackerX = new LinkedList<>();
        Queue<Integer> moveTrackerY = new LinkedList<>();

        moveTrackerX.add(cPX);
        moveTrackerY.add(cPY);

        while (moveTrackerX.size() > 0) {
            int tempX = moveTrackerX.remove();
            int tempY = moveTrackerY.remove();

            if (tempX == mousePosition.getX() && tempY == mousePosition.getY()) {
                Game.State = Game.STATE.LOSE;
                break;
            }

            nodesNextLayer = getBestMoveBFS(mousePosition, cPX, cPY, directionX, directionY, moveTrackerX, moveTrackerY, miniMap);
            //nextMove = getBestMoveBFS(mousePosition, cPX, cPY, directionX, directionY, moveTrackerX, moveTrackerY, miniMap);
            nodesCurrentLayer--;

            if (nodesCurrentLayer == 0) {
                nodesCurrentLayer = nodesNextLayer;
                depth--;
            }
        }

        //nextPosition.setX(tempX);
        //nextPosition.setY(tempY);
        
        
        //move(nextMove);
        
        
        System.out.println("MOUSE NOT CAUGHT");

    }

    //Implement using BFS with depth of 1 (1 cells, right, left, up and down)
    //Acknowledgements: Thanks to Kevin Litvin for the idea and https://www.youtube.com/watch?v=KiCBXu4P-2Y for the explanation :) 
    private int getBestMoveBFS(Position mouse, int catX, int catY, int[] dirX, int[] dirY, Queue<Integer> moveX, Queue<Integer> moveY, int[][] miniMap) {
        int nodeCounter = 0;
        Position nextPosition = new Position(catX, catY);


        for (int i = 0; i < 4; i++) {
            int tempX = catX + dirX[i];
            int tempY = catY + dirY[i];

            if (miniMap[tempX][tempY] == 0) {
                moveX.add(tempX);
                moveY.add(tempY);
                nodeCounter++;
            }

        }

        return nodeCounter;
        
    }
    */
    
    
    
} 