import java.awt.*;
import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Thimira Wijepala
 * @version 1.0
 */
public class Cheese extends StaticEntity {

    Position pos;

    /**
     * Instantiates this Cheese object and draws its image
     * on the map
     * 
     * @param x     Row coordinate on map
     * @param y     Column coordinate on map
     */
    public Cheese(int x, int y) {
        super(x, y);
        this.pos = generatePosition();
        points = 2;

        try{
            picture = ImageIO.read(new File("src/main/resources/cheese.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    //Returns the number of points received for collecting cheese
    public int getPoints() {
        return points;
    }

    /**
     * Returns a random Position where a new Cheese can spawn. 
     * This position is checked to ensure the cheese doesn't appear
     * on a barrier or on top of another character.
     * <p>
     * This method is called after 5 sec. of the previous Cheese
     * object despawning and will occur until the player loses or wins
     * the game
     * 
     * @return  Position object
     * @see     Position
     */
    protected Position generatePosition(){
        int maxX = 1450;
        int maxY = 1025;
        int x = 0 ,y = 0;
        boolean posAvail = false;
        while (!posAvail){
            x = (int)(Math.random() * maxX)/25;
            y = (int)(Math.random() * maxY)/25;
            if (Map.isWall(x,y) == 0 && Map.getItem(getPos()) == null && Map.getCharacter(x, y) == null){
                posAvail = true;
            }
        }
        return new Position(x,y);
    }

}
