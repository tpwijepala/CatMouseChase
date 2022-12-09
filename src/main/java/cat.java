import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Controls the movement of the cat and its graphics
 * 
 * @author Karina Kramer
 * @version 2.0
 */
class Cat extends MovingEntity {
    /**
     * Instantiates this cat's position and its image on
     * the game map
     * 
     * @param x Row coordinate on map
     * @param y Column coordinate on map
     * @param m Map where cat is located on
     */
    public Cat(int x, int y, Map m) {
        super(x, y, m);

        try{
            picture = ImageIO.read(new File("src/main/resources/catUP.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    
    /*
     * Adjust this cat picture to reflect direction it moves in
     * 
     * @param newPos    the next position this cat will move to
     */
    private void rotateCat(Position newPos){
        if (newPos.getX() - pos.getX() == 1){
            try{
                picture = ImageIO.read(new File("src/main/resources/catRight.png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }else if (newPos.getX() - pos.getX() == -1){
            try{
                picture = ImageIO.read(new File("src/main/resources/catLeft.png"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        }else if (newPos.getY() - pos.getY() == 1){
            try{
                picture = ImageIO.read(new File("src/main/resources/catDown.png"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        }else if (newPos.getY() - pos.getY() == -1){
            try{
                picture = ImageIO.read(new File("src/main/resources/catUp.png"));
            }catch(IOException e){
                e.printStackTrace();
            } 
        }
    }

    /*
     * Contains all the data relevant to the current position
     */
    private class PositionStruct {
        public PositionStruct prevPos;
        public Position pos;
        public int depth;
    }

    /**
     * Uses Breadth-First Search to move this cat to its
     * next position that is closer to the mouse
     * 
     * @param mousePosition Mouse's current position on the board
     */
    public void catchMouse(Position mousePosition) {
        // Acknowledgements: Thanks to Kevin Litvin for the idea and
        // https://www.youtube.com/watch?v=KiCBXu4P-2Y for the explanation :)

        int maxDepth = 3;
        int bestScore = -1;
        PositionStruct bestMove = null;
        ArrayList<PositionStruct> possibleMoves = new ArrayList<PositionStruct>();
        HashSet<Position> visitedPos = new HashSet<Position>();
        PositionStruct temp = new PositionStruct();

       
        //If the mouse moved on top of the cat first, end game
        if (checkMouseCollision(mousePosition)) {return;}

        temp.prevPos = null;
        temp.pos = getPos();
        temp.depth = 0;
        possibleMoves.add(temp);

        while (possibleMoves.size() > 0) {
            int curPosValue;
            PositionStruct curPos = possibleMoves.remove(0);

            visitedPos.add(curPos.pos);

            if (curPos.depth <= maxDepth) {
                getMovesFromPos(possibleMoves, curPos);
            }

            curPosValue = rateNextMoveManhattan(mousePosition, curPos.pos);

            // This ensures that this cat moves at all times
            if (curPos.pos != getPos() && (bestMove == null || bestScore > curPosValue)) {
                bestScore = curPosValue;
                bestMove = curPos;
            }

            // Stop search early if we hit mouse
            if (bestScore == 0) {
                break;
            }
        }

        while (bestMove.depth != 1) {
            bestMove = bestMove.prevPos;
        }

        rotateCat(bestMove.pos);
        move(bestMove.pos);

        //If the move that the cat takes collides with mouse, end game
        if (checkMouseCollision(mousePosition)) {return;}
    }

    /*
     * Checks if this cat and the mouse share the same cell.
     * If they do, end the game and the player loses.
     * 
     * @param mousePosition Mouse's current position
     * @return  boolean
     */
    private boolean checkMouseCollision (Position mousePosition) {
        if (getPos().getX() == mousePosition.getX() && getPos().getY() == mousePosition.getY()) {
            Game.State = Game.STATE.LOSE;
            return true;
        }

        return false;
    }

    /*
     * Scans the next cells in the north, south, east and west
     * directions to determine which ones this cat can move to
     * vs which ones are blocked and adds them to the list of
     * possible moves
     * 
     * @param possibleMoves ArrayList containing possible positions to move to next
     * @param curPos        Struct containing all relevant info pertaining to
     *                      current position
     */
    private void getMovesFromPos(ArrayList<PositionStruct> possibleMoves, PositionStruct curPos) {
        ArrayList<Position> adjacent = new ArrayList<Position>();
        adjacent.add(new Position(curPos.pos.getX() + 1, curPos.pos.getY()));
        adjacent.add(new Position(curPos.pos.getX() - 1, curPos.pos.getY()));
        adjacent.add(new Position(curPos.pos.getX(), curPos.pos.getY() + 1));
        adjacent.add(new Position(curPos.pos.getX(), curPos.pos.getY() - 1));

        for (Position pos : adjacent) {
            PositionStruct tempPos = new PositionStruct();
            tempPos.prevPos = curPos;
            tempPos.pos = pos;
            tempPos.depth = curPos.depth + 1;

            if (checkValidMove(tempPos.pos) && !(map.getCharacter(tempPos.pos) instanceof Cat)) {
                possibleMoves.add(tempPos);
            }
        }

    }
    /*
     * Uses Manhattan distance to give each possible next move a
     * rating
     * <p>
     * Manhattan distance is calculated by the number of cells
     * needed to reach the target moving only vertically and
     * horizontally
     * 
     * @param mousePos      current Mouse position
     * @param potentialMove a valid move the cat can take
     * @return rating as an integer
     */
    private int rateNextMoveManhattan(Position mousePos, Position potentialMove) {
        int rating = Math.abs(mousePos.getX() - potentialMove.getX())
                + Math.abs(mousePos.getY() - potentialMove.getY());

        return rating;
    }

} 
