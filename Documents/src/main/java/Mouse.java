//package main.java;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Mouse extends MovingEntity{
    private Image mousePic;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    //private Position mousePosition;
    //Position pos;
    Map map;
    private Score playerScore = new Score();

    /**
     * @param x
     * @param y
     * @param m
     */
    public Mouse(int x, int y, Map m) {
        super(x, y);
        map = m;
        try{
            mousePic = ImageIO.read(new File("src/main/resources/mouse.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Position getMousePosition() {
        return pos;
    }
    

    /*  TEMPORARY:
    public static void main(String[] args) {
        Mouse m = new Mouse(1, 1);

        Frame f = new Frame("test");

        f.addKeyListener(new UserInput(m));
        f.setSize(200, 200);
        f.setVisible(true);
    }
    */
    

    public void checkFinish() {
        Position end = map.getEnd();
        if (getPos().getX() == end.getX() && getPos().getY() == end.getY()) {
            // If all rewards collected:
                // End Game
        }
    }

    public void collectItem() {
        StaticEntity item = map.getItem(getPos());
        if (item != null) {
            playerScore.setScore(item.getPoints());
            System.out.println("ITEM POINTS: " + item.getPoints());
            // if playerScore.checkScoreBelowZero() == true:  End game
            map.removeItem(item);
        }
    }

    public Score getMouseScore() {
        return playerScore;
    }

    public void draw(Graphics g) {
        g.drawImage(mousePic, getPos().getX() * Map.CELLWIDTH, getPos().getY() * Map.CELLWIDTH, null);
    }
}
