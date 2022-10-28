import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import android.graphics.Point;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int mX = e.getX();
        int mY = e.getY();

        // Play button
        if (mX >= Game.WIDTH / 2 + 120 && mX <= Game.WIDTH / 2 + 220) {
            if (mY >= 150 && mY <= 200) {
                /// Pressed play Button
                Game.State = Game.STATE.GAME;
            }
        }

        if (mX >= Game.WIDTH / 2 + 120 && mX <= Game.WIDTH / 2 + 220) {
            if (mY >= 350 && mY <= 400) {
                /// Pressed quit Button
                System.exit(0);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}