import javax.imageio.ImageIO;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Author: Karina Kramer
 * Version: 1.0
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

   

    //NOTE: This is the attempt to implement a Breadth First Search algorithm to get a better move for the cat than the
    //      move in the above functions
    /*
    public void catchMouse(Position mousePosition) {
        //Acknowledgements: Thanks to Kevin Litvin for the idea and https://www.youtube.com/watch?v=KiCBXu4P-2Y for the explanation :) 

        int depth = 2;
        int nodesCurrentLayer = 1;
        int nodesNextLayer = 0;
        int cPX = getPos().getX();  //Cat's x coordinate on the game map
        int cPY = getPos().getY();  //Cat's y coordinate on the game map
        int[][] visitedCells = new int[5][5];
        int[] previousX = new int[25];  //Used to reconstruct path
        int[] previousY = new int[25];
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};

        int[][] miniMap = {{Map.isWall(cPX - 2, cPY - 2), Map.isWall(cPX - 1, cPY - 2), Map.isWall(cPX, cPY - 2), Map.isWall(cPX + 1, cPY - 2), Map.isWall(cPX + 2, cPY - 2)},
                           {Map.isWall(cPX - 2, cPY - 1), Map.isWall(cPX - 1, cPY - 1), Map.isWall(cPX, cPY - 1), Map.isWall(cPX + 1, cPY - 1), Map.isWall(cPX + 2, cPY - 1)},
                           {Map.isWall(cPX - 2, cPY), Map.isWall(cPX - 1, cPY), Map.isWall(cPX, cPY), Map.isWall(cPX + 1, cPY), Map.isWall(cPX + 2, cPY)},
                           {Map.isWall(cPX - 2, cPY + 1), Map.isWall(cPX - 1, cPY + 1), Map.isWall(cPX, cPY + 1), Map.isWall(cPX + 1, cPY + 1), Map.isWall(cPX + 2, cPY + 1)},
                           {Map.isWall(cPX - 2, cPY + 2), Map.isWall(cPX - 1, cPY + 2), Map.isWall(cPX, cPY + 2), Map.isWall(cPX + 1, cPY + 2), Map.isWall(cPX + 2, cPY + 2)}};

        Queue<Integer> moveTrackerX = new LinkedList<>();
        Queue<Integer> moveTrackerY = new LinkedList<>();

        //Start from the center of the map to line up with cPX and cPY
        int miniX = 2;
        int miniY = 2;

        //Add the starting position
        moveTrackerX.add(miniX);
        moveTrackerY.add(miniY);
        visitedCells[miniX][miniY] = 1;

        while (moveTrackerX.size() > 0) {
            int tempMiniX = moveTrackerX.remove();
            int tempMiniY = moveTrackerY.remove();

            //Since the cat's position is centered on the miniMap, we need to shift the coordinates
            int convertedX = cPX - 2 + tempMiniX;
            int convertedY = cPX - 2 + tempMiniY;

            //Convert mini coordinates to the map's coordinates
            if (convertedX == mousePosition.getX() && convertedY == mousePosition.getY()) {
                Game.State = Game.STATE.LOSE;
                //break;
            }

            nodesNextLayer = findNodes(miniX, miniY, directionX, directionY, moveTrackerX, moveTrackerY, miniMap);
            for ()
            /*nodesCurrentLayer--;

            if (nodesCurrentLayer == 0) {
                nodesCurrentLayer = nodesNextLayer;
                depth--;
            }
        }

        //nextPosition.setX(tempX);
        //nextPosition.setY(tempY);
        
        
        //move(nextMove);

    }
    */

    public void catchMouse(Position mousePosition) {
        //Acknowledgements: Thanks to Kevin Litvin for the idea and https://www.youtube.com/watch?v=KiCBXu4P-2Y for the explanation :) 

        int depth = 2;
        int nodesCurrentLayer = 1;
        int nodesNextLayer = 0;
        int cPX = getPos().getX();  //Cat's x coordinate on the game map
        int cPY = getPos().getY();  //Cat's y coordinate on the game map
        int[][] visitedCells = new int[5][5];
        int[] previousX = new int[25];  //Used to reconstruct path
        int[] previousY = new int[25];
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};

        int[][] miniMap = {{Map.isWall(cPX - 2, cPY - 2), Map.isWall(cPX - 1, cPY - 2), Map.isWall(cPX, cPY - 2), Map.isWall(cPX + 1, cPY - 2), Map.isWall(cPX + 2, cPY - 2)},
                           {Map.isWall(cPX - 2, cPY - 1), Map.isWall(cPX - 1, cPY - 1), Map.isWall(cPX, cPY - 1), Map.isWall(cPX + 1, cPY - 1), Map.isWall(cPX + 2, cPY - 1)},
                           {Map.isWall(cPX - 2, cPY), Map.isWall(cPX - 1, cPY), Map.isWall(cPX, cPY), Map.isWall(cPX + 1, cPY), Map.isWall(cPX + 2, cPY)},
                           {Map.isWall(cPX - 2, cPY + 1), Map.isWall(cPX - 1, cPY + 1), Map.isWall(cPX, cPY + 1), Map.isWall(cPX + 1, cPY + 1), Map.isWall(cPX + 2, cPY + 1)},
                           {Map.isWall(cPX - 2, cPY + 2), Map.isWall(cPX - 1, cPY + 2), Map.isWall(cPX, cPY + 2), Map.isWall(cPX + 1, cPY + 2), Map.isWall(cPX + 2, cPY + 2)}};

        Queue<Integer> moveTrackerX = new LinkedList<>();
        Queue<Integer> moveTrackerY = new LinkedList<>();

        //Start from the center of the map to line up with cPX and cPY
        int miniX = 2;
        int miniY = 2;

        //Add the starting position
        moveTrackerX.add(miniX);
        moveTrackerY.add(miniY);
        visitedCells[miniX][miniY] = 1;

        //while (moveTrackerX.size() > 0) {
            int tempMiniX = moveTrackerX.remove();
            int tempMiniY = moveTrackerY.remove();

            //Since the cat's position is centered on the miniMap, we need to shift the coordinates
            int convertedX = cPX - 2 + tempMiniX;
            int convertedY = cPX - 2 + tempMiniY;

            //Convert mini coordinates to the map's coordinates
            if (convertedX == mousePosition.getX() && convertedY == mousePosition.getY()) {
                Game.State = Game.STATE.LOSE;
                //break;
            }

            nodesNextLayer = findNodes(miniX, miniY, directionX, directionY, moveTrackerX, moveTrackerY, miniMap);
            for (int i = 0; i < moveTrackerX.size(); i++) {
                System.out.println("I = " + i);
                System.out.println("TRACKER X: " + moveTrackerX.remove(i));
                System.out.println("TRACKER Y: " + moveTrackerY.remove(i));
            }
            /*nodesCurrentLayer--;

            if (nodesCurrentLayer == 0) {
                nodesCurrentLayer = nodesNextLayer;
                depth--;
            }*/
        //}

        //nextPosition.setX(tempX);
        //nextPosition.setY(tempY);
        
        
        //move(nextMove);

    }









    /**
     * Returns the number of nodes the cat can move to
     * @param miniX
     * @param miniY
     * @param dirX
     * @param dirY
     * @param moveX
     * @param moveY
     * @param miniMap
     * @return
     */
    private int findNodes(int miniX, int miniY, int[] dirX, int[] dirY, Queue<Integer> moveX, Queue<Integer> moveY, int[][] miniMap) {
        int nodeCounter = 0;

        for (int i = 0; i < 4; i++) {
            int tempX = miniX + dirX[i];
            int tempY = miniY + dirY[i];

            //Check is next move is a barrier
            if (miniMap[tempX][tempY] == 0) {
                moveX.add(tempX);
                moveY.add(tempY);
                nodeCounter++;
            }

        }

        return nodeCounter;
    }

    
    private Position getBestMoveBFS(Position mouse, int x, int y) {
    
        Position nextPosition = new Position(x, y);


        
        return nextPosition;
    }
    
} 