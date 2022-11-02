package main.java;

import java.awt.*;

public class MouseTrap extends StaticEntity {

    final private int points = -1;  // Placeholder value
    private Image trapPic;

    public MouseTrap(Position pos) {
        super(pos);
    }

    protected int getPoints() {
        return points;
    }
}
