//package main.java;

import java.awt.*;
import java.lang.Math;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Cheese extends StaticEntity {

    final private int points = 2;  // Placeholder value
    private int timer = 30;  // Placeholder value
    Position pos;

    
    public Cheese(int x, int y) {
        super(x, y);
        this.pos = generatePosition();

        try{
            picture = ImageIO.read(new File("src/main/resources/cheese.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    public int getPoints() {
        return points;
    }

    public void countdown() {
        timer -= 1;
    }

    public int getTimer() {
        return timer;
    }

    /**
     * Returns a random Position where a new Cheese can spawn. 
     * This position is checked to ensure the cheese doesn't appear
     * on a barrier or on top of another character.
     * <p>
     * This method is called after 5 sec. of the previous Cheese
     * object despawning and will occur until the player loses or wins
     * the game
     * 
     * @return  Position object
     * @see     Position
     */
    protected Position generatePosition(){
        int maxX = 1450;
        int maxY = 1025;
        int x = 0 ,y = 0;
        boolean posAvail = false;
        while (!posAvail){
            x = (int)(Math.random() * maxX)/25;
            y = (int)(Math.random() * maxY)/25;
            if (Map.isWall(x,y) == 0 && Map.getItem(getPos()) == null && Map.getCharacter(x, y) == null){
                posAvail = true;
            }
        }
        return new Position(x,y);
    }

}
