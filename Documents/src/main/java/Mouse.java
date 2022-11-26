<<<<<<<<<Temporary merge branch 1=========
//package main.java;

>>>>>>>>>Temporary merge branch 2

import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a Mouse that is controlled by the player
 * 
 * @author Robert Wilson
 * @version 1.0
 */
public class Mouse extends MovingEntity {
    <<<<<<<<<
    Temporary merge branch 1=========
    // private Image picture; // mousePic can be declared const and given an initial
    // value once a picture is found and included in files
    // private Position mousePosition;
    // Position pos;
    Map map;
    private Score playerScore = new Score();
    Position newPos;>>>>>>>>>
    Temporary merge branch 2

    private Map map;
    private Score playerScore = new Score();
    Position newPos;

    public Mouse(int x, int y, Map m) {
        super(x, y, m);
        map = m;
        newPos = pos;
        try {
            picture = ImageIO.read(new File("src/main/resources/mouse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Position getMousePosition() {
        return pos;
    }

    /**
     * @return Mouse's current position
     */
    public Position getMousePosition() {
        return pos;
    }

    /**
     * Checks if this mouse meets the requirements to finish the game,
     * ending the game if met.
     */
    public void checkFinish() {
<<<<<<<<< Temporary merge branch 1
        Position end = map.getEnd();
        if (getPos().getX() == end.getX() && getPos().getY() == end.getY()) {
            if (map.crumbsCollect == 4) {
                Game.State = Game.STATE.WIN;
            }
            
=========
        Position[] end = map.getEnd();
        //System.out.println("INSIDE checkFinish. X = " + getMousePosition().getX() + " Y = " + getMousePosition().getY());
        if (getMousePosition().getX() == end[0].getX()) {
            for (int i = 0; i < end.length; i++) {
                if (getMousePosition().getY() == end[i].getY()) {
                    //if (Map.crumbsCollect == 4) {
                        //System.out.println("MOUSE WON");
                        Game.State = Game.STATE.WIN;
                    //}
                    
                    Game.State = Game.STATE.WIN;
                }
            }
>>>>>>>>> Temporary merge branch 2
        }
    }

    private void collectItem() {
        StaticEntity item = map.getItem(getPos());
        if (item != null) {
            if (item instanceof Cheese)
                map.cheeseExist(true);

            if (item instanceof Crumb)
                map.crumbsCollect++;
            
            playerScore.setScore(item.getPoints());
            
<<<<<<<<< Temporary merge branch 1
            
=========
>>>>>>>>> Temporary merge branch 2
            if (playerScore.checkScoreBelowZero() == true) {
                Game.State = Game.STATE.LOSE;
            }
        }
        else{
        }
    }

    <<<<<<<<<

    Temporary merge branch 1/**
                             * @return Mouse's current score
                             */
    =========>>>>>>>>>
    Temporary merge branch 2

    public Score getMouseScore() {
        return playerScore;
    }

    public void setMouseScore() {
        playerScore = new Score();
    }
}
