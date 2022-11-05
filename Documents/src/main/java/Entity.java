//package main.java;

import java.awt.*;

public class Entity {
    Position pos;

    public Entity(int x, int y) {
        pos = new Position(x, y);
    }

    /*
    public Entity(Position pos) {
        this.pos = pos;
    }
    */

    public Position getPos() {
        return pos;
    }

    //Not on UML
    public void setPos(int newX, int newY) {
        pos.setX(newX);
        pos.setY(newY);
    }

    public void draw(Graphics g, Image picture) {
        //g.drawRect(pos.x, pos.y, 10, 10);
        // TO-DO:
        //   Dependent on implementation of Map class and how the program window is created
        g.drawImage(picture, pos.getX()*25, pos.getY()*25, null);
    }

    public void draw(Graphics g) {
        //g.drawImage(picture, pos.x,pos.y, null);
    }
}


