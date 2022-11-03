import java.awt.*;

public class Mouse extends MovingEntity{
    private Image mousePic;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    private Score playerScore;
    //private Position mousePosition;
    Position pos;

    public Mouse(int x, int y) {
        super(x, y);
    }

    public Position getMousePosition() {
        return this.pos;
    }

    public void checkFinish() {
        Position end = map.getEnd();
        if (pos.x == end.x && pos.y == end.y) {
            // If all rewards collected:
                // End Game
        }
    }

    public void collectItem() {
        StaticEntity item = map.getItem(pos);
        if (item != null) {
            playerScore.setScore(item.getPoints());
            // if playerScore.checkScoreBelowZero() == true:  End game
            map.removeItem(item);
        }
    }


}
