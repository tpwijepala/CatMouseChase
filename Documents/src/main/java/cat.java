//package main.java;

import javax.imageio.ImageIO;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Cat extends MovingEntity {
    Position currentPosition;

    public Cat(int x, int y) {
        super(x, y);

        try{
            picture = ImageIO.read(new File("src/main/resources/cat.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void startMove(Position mousePos) {
        System.out.println("CAT START MOVE TRIGGERED");
        //long startTime, timer;

        //startTime = System.currentTimeMillis();
        //timer = System.currentTimeMillis() - startTime;

        catchMouse(mousePos);
    }

    //p will probably be mouse's current position
    public void catchMouse(Position p) {

        System.out.println("CATCH MOUSE TRIGGERED");
        Position nextMove = getBestMove(p);
        System.out.println("CAT NEXT MOVE: " + nextMove);
        move(nextMove);
        
        if (nextMove.getX() == p.getX() && nextMove.getY() == p.getY()) {
            Game.State = Game.STATE.LOSE;
            //return;
        }
        System.out.println("MOUSE NOT CAUGHT");

    }

    
    private Position getBestMove(Position p) {
        int moveUp = 0;
        int moveDown = 0;
        int moveRight = 0;
        int moveLeft = 0;
        currentPosition = getPos();
        System.out.println("CAT CURRENT POSITION: " + currentPosition);
        Position nextPosition = new Position(currentPosition.getX(), currentPosition.getY());
        System.out.println("CAT NEXT POSITION INITIALIZED: " + nextPosition);

        //Check BFS or store 
        //Check where the mouse is in proximity to cat
        if (currentPosition.getY() < p.getY()) {
            moveUp = currentPosition.getY() + 1;
            nextPosition.setY(moveUp);
        }

        else if (currentPosition.getY() > p.getY()) {
            moveDown = currentPosition.getY() - 1;
            nextPosition.setY(moveDown);
        }
        
        else if (currentPosition.getX() < p.getX()) {
            moveRight = currentPosition.getX() + 1;
            nextPosition.setX(moveRight);
        }

        else {
            moveLeft = currentPosition.getX() - 1;
            nextPosition.setX(moveLeft);
        }

        //Check for any other cats
        //Develop the rest of this code here
        System.out.println("CAT BEST MOVE: " + nextPosition);
        return nextPosition;

    }

    /* //Implement using BFS with depth of 3
    private Position getBestMove(Position p) {
        currentPosition = getPos();
        Position nextPosition = new Position(currentPosition.getX(), currentPosition.getY());

    }
    */
}