import java.awt.*;

public class Entity {
    private int x;
    private int y;
    Position pos;
    Map map;

    public Position getPos() {
        return pos;
    }

    public void draw(Graphics g, Image picture) {
        //g.drawRect(pos.x, pos.y, 10, 10);
        // TO-DO:
        //   Dependent on implementation of Map class and how the program window is created
        g.drawImage(picture, pos.x,pos.y, null);
    }
}


