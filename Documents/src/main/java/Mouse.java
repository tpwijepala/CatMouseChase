//package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Mouse extends MovingEntity{
    //private Image picture;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    //private Position mousePosition;
    //Position pos;
    Map map;
    private Score playerScore = new Score();
    Position newPos;

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
    
    public Position getMousePosition() {
        return pos;
    }

    public void checkFinish() {
        Position end = map.getEnd();
        if (getPos().getX() == end.getX() && getPos().getY() == end.getY()) {
            // If all rewards collected:
                // End Game
        }
    }

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

    public Score getMouseScore() {
        return playerScore;
    }

    /*
    public void draw(Graphics g) {
        g.drawImage(mousePic, getPos().getX() * Map.CELLWIDTH, getPos().getY() * Map.CELLWIDTH, null);
    }
    */
}
