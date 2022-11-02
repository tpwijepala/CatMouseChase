import java.awt.*;

public class Entity {
    Position pos;
    Map map;

    public Entity(int eX, int eY) {
        this.pos = new Position(eX, eY);
    }

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


