import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to mainly create MouseTrap objects
 * which will decrease score when picked up by Mouse.
 * 
 * @author
 */

public class MouseTrap extends StaticEntity {
    /**
     * MouseTrap Constructuor
     * Used to initalize objects position & load img
     * 
     * @param x - used to initalize x pos
     * @param y - used to initalize y pos
     */
    public MouseTrap(int x, int y) {
        super(x, y);
        points = -1;
        
        try{
            picture = ImageIO.read(new File("src/main/resources/trap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
