import java.awt.*;

public class Cheese extends StaticEntity {

    final private int points = 2;  // Placeholder value
    private Image cheesePic;
    private int timer = 30;  // Placeholder value

    public Cheese(Position pos) {
        this.pos = pos;
    }

    protected int getPoints() {
        return points;
    }

    public void countdown() {
        timer -= 1;
    }

    public int getTimer() {
        return timer;
    }
}
