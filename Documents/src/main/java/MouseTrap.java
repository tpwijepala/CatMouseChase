import javax.imageio.ImageIO;
import java.awt.*;
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
    final private int points = -1;

    /**
     * MouseTrap Constructuor
     * Used to initalize objects position & load img
     * 
     * @param x - used to initalize x pos
     * @param y - used to initalize y pos
     */
    public MouseTrap(int x, int y) {
        super(x, y);
        try {
            picture = ImageIO.read(new File("src/main/resources/trap.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getPoints() {
        return points;
    }

    