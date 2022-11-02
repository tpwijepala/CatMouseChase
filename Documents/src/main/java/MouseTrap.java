import java.awt.*;

public class MouseTrap extends StaticEntity {

    final private int points = -1;  // Placeholder value
    private Image trapPic;

    public MouseTrap(int x, int y) {
        super(x, y);
    }
    
    /*
    public MouseTrap(Position pos) {
        this.pos = pos;
    }
    */
    protected int getPoints() {
        return points;
    }
}
