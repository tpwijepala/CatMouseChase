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

    public void draw(Graphics g) {
        g.drawImage(picture, pos.x*25,pos.y*25, null);
    }
}


