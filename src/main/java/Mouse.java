import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a Mouse that is controlled by the player
 * 
 * @author Robert Wilson
 * @version 1.0
 */
public class Mouse extends MovingEntity {
    // private Image picture; // mousePic can be declared const and given an initial
    // value once a picture is found and included in files
    // private Position mousePosition;
    // Position pos;
    Map map;
    private Score playerScore = new Score();
    Position newPos;

    public Mouse(int x, int y, Map m) {
        super(x, y, m);
        map = m;
        newPos = pos;
        try {
            picture = ImageIO.read(new File("src/main/resources/mouseRight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Rotate the Mouse's picture depending on which direction it moves
     * 
     * @param side
     */
    public void rotateMouse(int side) {
        if (side == 0){
            try {
                picture = ImageIO.read(new File("src/main/resources/mouseUp.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (side == 1){
            try {
                picture = ImageIO.read(new File("src/main/resources/mouseLeft.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (side == 2){
            try {
                picture = ImageIO.read(new File("src/main/resources/mouseDown.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (side == 3){
            try {
                picture = ImageIO.read(new File("src/main/resources/mouseRight.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Position getMousePosition() {
        return pos;
    }

    public void move() {
        move(newPos);
        collectItem();
        checkFinish();
    }

    /*
     * Checks if this mouse meets the requirements to finish the game,
     * ending the game if met.
     */
    private void checkFinish() {
        ArrayList<Position> end = map.getEnd();
        if (map.crumbsCollect >= 10) {
            for (int i = 0; i < end.size(); i++){
                if (getPos().getX() == end.get(i).getX() && getPos().getY() == end.get(i).getY()){
                    
                    Game.State = Game.STATE.WIN;
                }
            }
        }
    }

    /**
     * Checks to see if space Mouse is currently on contains a Cheese, Crumb, or Mouse Trap
     * <p>
     * Checks the score after the points are adjusted to see if it dropped below 0.
     */
    public void collectItem() {
        StaticEntity item = map.getItem(getPos());
        if (item != null) {
            if (item instanceof Cheese)
                map.cheeseExist(true);

            if (item instanceof Crumb)
                map.crumbsCollect++;

            playerScore.setScore(item.getPoints());
            map.removeItem(item);

            if (playerScore.checkScoreBelowZero() == true) {
                Game.State = Game.STATE.LOSE;
            }
        } else {
        }
    }

    public Score getMouseScore() {
        return playerScore;
    }

    public void setMouseScore() {
        playerScore = new Score();
    }
}
