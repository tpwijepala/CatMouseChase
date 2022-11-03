package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Crumb extends StaticEntity{

    final private int points = 1;  // Placeholder value
    private Image crumbPic;

    public Crumb(int x, int y) {
        super(x, y);
        try{
            crumbPic = ImageIO.read(new File("Documents/src/main/resources/crumbs.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics g) {
        g.drawImage(crumbPic, pos.x * Map.CELLWIDTH, pos.y * Map.CELLWIDTH, null);
    }

    protected int getPoints() {
        return points;
    }
}
