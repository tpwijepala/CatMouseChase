package main.java;

import java.awt.*;

public class MouseTrap extends StaticEntity {

    final private int points = -1;
    private Image trapPic;

    public MouseTrap(Position pos) {
        this.pos = pos;
    }

    protected int getPoints() {
        return points;
    }
}
