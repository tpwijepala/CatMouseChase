import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Represents a Mouse that is controlled by the player
 * @author Robert Wilson
 * @version 1.0
 */
public class Mouse extends MovingEntity{

    private Map map;
    private Score playerScore = new Score();
    Position newPos;

    /**
     * @param x X-Coordinate
     * @param y Y-Coordinate
     * @param m Map that will contain the mouse
     */
    public Mouse(int x, int y, Map m) {
        super(x,y);
        map = m;
        newPos = pos;
        try{
            picture = ImageIO.read(new File("src/main/resources/mouse.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * @return Mouse's current position
     */
    public Position getMousePosition() {
        return pos;
    }

    /**
     * Checks if this mouse meets the requirements to finish the game,
     * ending the game if met.
     */
    public void checkFinish() {
        Position end = map.getEnd();
        if (getPos().getX() == end.getX() && getPos().getY() == end.getY()) {
            if (map.crumbsCollect == 4) {
                Game.State = Game.STATE.WIN;
            }
            
        }
    }

    /**
     * Checks if this mouse's position intersects an item's position.
     * If an item is present, it is collected by this mouse,
     * adjusting its score and removing the item from the map.
     * If collecting the item drops this player's score below
     * zero, the game ends.
     * @see Score
     */
    public void collectItem() {
        StaticEntity item = Map.getItem(getPos());
        if (item != null) {
            playerScore.setScore(item.getPoints());
            
            
            if (playerScore.checkScoreBelowZero() == true) {
                Game.State = Game.STATE.LOSE;
            }

            else {
                map.removeItem(item);
            }
            
        }
    }

    /**
     * @return Mouse's current score
     */
    public Score getMouseScore() {
        return playerScore;
    }
}
