package main.java;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

class Cat extends MovingEntity {
    Image catPic;

    public Cat(int x, int y) {
        super(x, y);
        try{
            catPic = ImageIO.read(new File("Documents/src/main/resources/cat.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void catchMouse(Position p) {
        

    }

    private void getBestMove(Position p) {

    }
}