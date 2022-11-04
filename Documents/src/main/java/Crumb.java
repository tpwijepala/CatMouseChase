import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Crumb extends StaticEntity{
    public Crumb(int x, int y){
        super(x,y);

        try{
            picture = ImageIO.read(new File("src/main/resources/crumbs.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    final private int points = 1;  // Placeholder value

    protected int getPoints() {
        return points;
    }
}
