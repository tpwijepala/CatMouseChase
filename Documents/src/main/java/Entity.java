//package main.java;

import java.awt.*;

public class Entity {
    Position pos;
    Map map;

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


