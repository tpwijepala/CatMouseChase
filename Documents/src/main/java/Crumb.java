package main.java;

import java.awt.*;

public class Crumb extends StaticEntity{

    public Crumb(int x, int y) {
        super(x, y);
    }

    final private int points = 1;  // Placeholder value
    private Image crumbPic;

    protected int getPoints() {
        return points;
    }
}
