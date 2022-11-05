//package main.java;

import java.awt.*;

public class Entity {
    Position pos;
    Map map;
    Image picture;

    public Entity(int x, int y){
        pos = new Position(x, y);
    }

    public Position getPos() {
        return pos;
    }

    //Not on UML
    public void setPos(int newX, int newY) {
        pos.setX(newX);
        pos.setY(newY);
    }

    public void draw(Graphics g) {
        g.drawImage(picture, pos.getX()*25, pos.getY()*25, null);
    }

}


