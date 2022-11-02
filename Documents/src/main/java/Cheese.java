package main.java;

import java.awt.*;
import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Cheese extends StaticEntity {

    final private int points = 2;  // Placeholder value
    private Image cheesePic;
    private int timer = 30;  // Placeholder value

    public Cheese() {
        super(generatePosition());

    }

    protected int getPoints() {
        return points;
    }

    public void countdown() {
        timer -= 1;
    }

    public int getTimer() {
        return timer;
    }

    protected static Position generatePosition(){
        int maxX = 626;
        int maxY = 444;
        int x =0 ,y = 0;
        boolean posAvail = false;
        while (!posAvail){
            x = (int)(Math.random() * maxX);
            y = (int)(Math.random() * maxY);
            if (Map.isWall((int)(x/58),(int)(y/41)) == 0){
                posAvail = true;
            }
        }
        return new Position(x,y);
    }

}
