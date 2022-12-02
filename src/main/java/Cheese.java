import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * @author Thimira Wijepala
 * @version 1.0
 */
public class Cheese extends StaticEntity {
    Map map;
    /**
     * Instantiates this Cheese object and draws its image
     * on the map
     * 
     * @param x     Row coordinate on map
     * @param y     Column coordinate on map
     */
    public Cheese(int x, int y, Map m) {
        super(x, y);
        map = m;
        this.pos = generatePosition();
        points = 2;
        

        try{
            picture = ImageIO.read(new File("src/main/resources/cheese.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
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
        int maxXCells = Game.WIDTH/map.CELLWIDTH;
        int maxYCells = Game.HEIGHT/map.CELLWIDTH;
        int x = 0 ,y = 0;
        boolean posAvail = false;
        while (!posAvail){
            x = (int)(Math.random() * maxXCells);
            y = (int)(Math.random() * maxYCells);
            if (map.isWall(x,y) == 0 && map.getItem(getPos()) == null && map.getCharacter(getPos()) == null){
                posAvail = true;
            }
        }
        return new Position(x,y);
    }

}
