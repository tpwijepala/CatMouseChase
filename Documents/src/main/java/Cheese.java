//package main.java;

import java.awt.*;
import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Cheese extends StaticEntity {
    
    public Cheese(int x, int y) {
        super(x, y);
        this.pos = generatePosition();
        points = 2;

        try{
            picture = ImageIO.read(new File("src/main/resources/cheese.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    protected Position generatePosition(){
        int maxX = 1450;
        int maxY = 1025;
        int x = 0 ,y = 0;
        boolean posAvail = false;
        while (!posAvail){
            x = (int)(Math.random() * maxX)/25;
            y = (int)(Math.random() * maxY)/25;
            if (Map.isWall(x,y) == 0 && Map.getItem(getPos()) == null && Map.getCharactr(x, y) == null){
                posAvail = true;
            }
        }
        return new Position(x,y);
    }

}
