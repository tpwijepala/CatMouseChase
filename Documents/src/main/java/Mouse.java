package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mouse extends MovingEntity{
    private Image mousePic;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    private Score playerScore;

    public Mouse(int x, int y, Map m) {
        super(x, y);
        map = m;
        try{
            mousePic = ImageIO.read(new File("Documents/src/main/resources/mouse.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void checkFinish() {
        Position end = map.getEnd();
        if (pos.x == end.x && pos.y == end.y) {
            // If all rewards collected:
                // End Game
        }
    }

    public void collectItem() {
        StaticEntity item = map.getItem(pos);
        if (item != null) {
            playerScore.setScore(item.getPoints());
            // if playerScore.checkScoreBelowZero() == true:  End game
            map.removeItem(item);
        }
    }

    public void draw(Graphics g) {
        g.drawImage(mousePic, pos.x * Map.CELLWIDTH, pos.y * Map.CELLWIDTH, null);
    }
}
