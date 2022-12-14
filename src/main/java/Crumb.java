import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to mainly create crumb objects
 * which can be picked up by Mouse to increase score.
 * 
 */
public class Crumb extends StaticEntity{

    /**
     * Crumb Constructuor
     * Used to initalize objects position and load image
     * 
     * @param x - used to initalize x pos
     * @param y - used to initalize y pos
     */
    public Crumb(int x, int y){
        super(x,y);
        points = 1;

        try {
            picture = ImageIO.read(new File("src/main/resources/crumbs.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
