//package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MouseTrap extends StaticEntity {

    final private int points = -1;  // Placeholder value
    private Image trapPic;

    public MouseTrap(int x, int y) {
        super(x, y);
        try{
            trapPic = ImageIO.read(new File("src/main/resources/trap.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    /*
    public MouseTrap(Position pos) {
        super(pos);
        try{
            trapPic = ImageIO.read(new File("src/main/resources/trap.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    */

    public void draw(Graphics g) {
        g.drawImage(trapPic, pos.x * Map.CELLWIDTH, pos.y * Map.CELLWIDTH, null);
    }
    
    public int getPoints() {
        return points;
    }
}
