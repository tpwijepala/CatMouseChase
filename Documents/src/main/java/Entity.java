package main.java;
import java.awt.*;

public class Entity {
    private int x;
    private int y;
    Position pos;
    /*Graphics g;

    public Entity(Graphics g) {
        this.g = g;
    }
*/
    public Position getPos() {
        return pos;
    }

    //May or may not want to implement this later depending on complexity of code
    //public Boolean collision() {}

    public void draw(Image picture) {
        //g.drawRect(pos.x, pos.y, 10, 10);
        // TO-DO:
        //   Dependent on implementation of Map class and how the program window is created
    }
}


