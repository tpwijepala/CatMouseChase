import javax.imageio.ImageIO;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Mouse extends MovingEntity {
    // private Image picture; // mousePic can be declared const and given an initial
    // value once a picture is found and included in files
    // private Position mousePosition;
    // Position pos;
    Map map;
    private Score playerScore = new Score();
    Position newPos;

    public Mouse(int x, int y, Map m) {
        super(x, y);
        map = m;
        newPos = pos;
        try {
            picture = ImageIO.read(new File("src/main/resources/mouse.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Position getMousePosition() {
        return pos;
    }

    public void checkFinish() {
        Position[] end = map.getEnd();
        // System.out.println("INSIDE checkFinish. X = " + getMousePosition().getX() + "
        // Y = " + getMousePosition().getY());
        if (getMousePosition().getX() == end[0].getX()) {
            for (int i = 0; i < end.length; i++) {
                if (getMousePosition().getY() == end[i].getY()) {
                    // if (map.crumbsCollect == 4) {
                    // System.out.println("MOUSE WON");
                    Game.State = Game.STATE.WIN;
                    // }

                }
            }
        }
    }

    public void collectItem() {
        StaticEntity item = Map.getItem(getPos());
        if (item != null) {
            playerScore.setScore(item.getPoints());
            // System.out.println(item.getPoints());

            if (item instanceof Cheese)
                map.cheeseExist(true);

            if (playerScore.checkScoreBelowZero() == true) {
                Game.State = Game.STATE.LOSE;
            }

            else {
                map.removeItem(item);
            }

        }
    }

    public Score getMouseScore() {
        return playerScore;
    }

    public void setMouseScore() {
        playerScore = new Score();
    }
}
