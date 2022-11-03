import java.awt.*;

public class Entity {
    Position pos;
    Map map;
    Image picture;

    public Position getPos() {
        return pos;
    }

    public void draw(Graphics g) {
        //g.drawRect(pos.x, pos.y, 10, 10);
        // TO-DO:
        //   Dependent on implementation of Map class and how the program window is created
        g.drawImage(picture, pos.x*25,pos.y*25, null);
    }
}


