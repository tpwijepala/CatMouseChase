package game;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Mouse extends MovingEntity{
    private Image mousePic;  // mousePic can be declared const and given an initial value once a picture is found and included in files

    public Mouse(int x, int y) {
        pos = new Position(x, y);
    }

    public static void main(String[] args) {
        Mouse m = new Mouse(1, 1);

        Frame f = new Frame("test");
        f.addKeyListener(new UserInput(m));
        f.setSize(200, 200);
        f.setVisible(true);

    }


}
