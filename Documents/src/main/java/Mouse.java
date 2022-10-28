package main.java;

import java.awt.*;

public class Mouse extends MovingEntity{
    private Image mousePic;  // mousePic can be declared const and given an initial value once a picture is found and included in files
    // TO-DO: private Score playerScore;

    public Mouse(int x, int y) {
        pos = new Position(x, y);
    }

    /*  TEMPORARY:
    public static void main(String[] args) {
        Mouse m = new Mouse(1, 1);

        Frame f = new Frame("test");

        f.addKeyListener(new UserInput(m));
        f.setSize(200, 200);
        f.setVisible(true);

    }
    */

    public void checkFinish() {
        //  TO-DO:
        //    if pos == finish position && all rewards collected:
        //      end game
    }

    public void collectItem() {
        //  TO-DO:
        //    if pos == position of any item:
        //      get points of the item
        //      adjust score based on those points
        //      despawn item
    }


}
