import javax.imageio.ImageIO;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.Math.*;

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
    public Cat(int x, int y, Map m) {
        super(x, y, m);

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
        catchMouse(mousePos);
    }

    /**
     * Contains all the data relevant to the current position
     */
    private class PositionStruct{
        public PositionStruct prevPos;
        public Position pos;
        public int depth; 
    }

    /**
     * Uses Breadth-First Search to move this cat to its
     * next position that is closer to the mouse
     * 
     * @param mousePosition     Mouse's current position on the board
     */
    private void catchMouse(Position mousePosition) {
        //Acknowledgements: Thanks to Kevin Litvin for the idea and https://www.youtube.com/watch?v=KiCBXu4P-2Y for the explanation :) 

        int maxDepth = 1;
        int bestScore = -1;
        PositionStruct bestMove = null;
        ArrayList<PositionStruct> possibleMoves = new ArrayList<PositionStruct>();
        HashSet<Position> visitedPos = new HashSet<Position>();
        PositionStruct temp = new PositionStruct();

        temp.prevPos = null;
        temp.pos = getPos();
        temp.depth = 0;
        possibleMoves.add(temp);

        while(possibleMoves.size() > 0){
            int curPosValue;
            PositionStruct curPos = possibleMoves.remove(0);

            if (visitedPos.contains(curPos.pos)) { continue; }

            visitedPos.add(curPos.pos);

            if (curPos.depth <= maxDepth){
                getMovesFromPos(possibleMoves, curPos);
            }

            curPosValue = rateNextMoveManhattan(mousePosition, curPos.pos);

            // This ensures that this cat moves at all times
            if (curPos.pos != getPos() && (bestMove == null || bestScore > curPosValue )){
                bestScore = curPosValue;
                bestMove = curPos;
            }

            // Stop search early if we hit mouse
            if (bestScore == 0){
                break;
            }
        }

        while (bestMove.depth != 1){
            bestMove = bestMove.prevPos;
        }

        move(bestMove.pos);

        //If the move that the cat takes collides with mouse, end game
        if (bestMove.pos.getX() == mousePosition.getX() && bestMove.pos.getY() == mousePosition.getY()) {
            Game.State = Game.STATE.LOSE;
        }
    }

    /**
     * Scans the next cells in the north, south, east and west
     * directions to determine which ones this cat can move to 
     * vs which ones are blocked and adds them to the list of
     * possible moves
     * 
     * @param possibleMoves     ArrayList containing possible positions to move to next
     * @param curPos            Struct containing all relevant info pertaining to current position
     */
    private void getMovesFromPos(ArrayList<PositionStruct> possibleMoves, PositionStruct curPos){
        ArrayList<Position> adjacent = new ArrayList<Position>();
        adjacent.add(new Position(curPos.pos.getX()+1, curPos.pos.getY()));
        adjacent.add(new Position(curPos.pos.getX()-1, curPos.pos.getY()));
        adjacent.add(new Position(curPos.pos.getX(), curPos.pos.getY()+1));
        adjacent.add(new Position(curPos.pos.getX(), curPos.pos.getY()-1));

        for (Position pos : adjacent) {
            PositionStruct tempPos = new PositionStruct();
            tempPos.prevPos = curPos;
            tempPos.pos = pos;
            tempPos.depth = curPos.depth + 1;

            if (checkValidMove(tempPos.pos)) {
                possibleMoves.add(tempPos);
            }
        }

    }

    /**
     * Uses Manhattan distance to give each possible next move a
     * rating
     * <p>
     * Manhattan distance is calculated by the number of cells
     * needed to reach the target moving only vertically and
     * horizontally
     * @param mousePos      current Mouse position
     * @param potentialMove a valid move the cat can take
     * @return      rating as an integer
     */
    private int rateNextMoveManhattan(Position mousePos, Position potentialMove){
        int rating = Math.abs(mousePos.getX() - potentialMove.getX()) + Math.abs(mousePos.getY() - potentialMove.getY());

        return rating;
    }
    
} 