import java.awt.*;

public class Crumb extends StaticEntity{

    final private int points = 1;  // Placeholder value
    private Image crumbPic;

    public Crumb(int x, int y) {
        super(x, y);
    }

    protected int getPoints() {
        return points;
    }
}
