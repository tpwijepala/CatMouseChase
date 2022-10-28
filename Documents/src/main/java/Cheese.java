package main.java;

import java.awt.*;

public class Cheese extends StaticEntity {

    final private int points = 2;
    private Image cheesePic;
    private int timer = 0;

    public Cheese(Position pos) {
        this.pos = pos;
    }

    protected int getPoints() {
        return points;
    }

    public void countdown() {
        timer -= 1;
    }
}
