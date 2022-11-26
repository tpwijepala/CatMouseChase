import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Transient;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.Robot;
import org.junit.jupiter.api.BeforeEach;

public class MenuTest {
    Menu menu;
    int buttonX = Game.WIDTH / 2 - 300 / 2;
    Robot testRobot;
    MouseEvent press, release, click;
    Point point;
    long time;
    Game instance;

    @BeforeEach
    public void resetMenu() {

        instance = new Game();
        menu = new Menu();
        Game.State = Game.STATE.MENU;

    }

    /**
     * Test that play button has been clicked
     */
    @Test
    public void clickPlay() {

        int buttonY = menu.playY;
        point = new Point(buttonX, buttonY);
        time = System.currentTimeMillis();

        SwingUtilities.convertPointToScreen(point, instance);
        click = new MouseEvent(instance, MouseEvent.MOUSE_CLICKED, time, 0, buttonX, buttonY, point.x, point.y, 1,
                false,
                MouseEvent.BUTTON1);

        instance.dispatchEvent(click);

        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public void clickHelp() {
        int buttonY = menu.helpY;
        point = new Point(buttonX, buttonY);
        time = System.currentTimeMillis();

        SwingUtilities.convertPointToScreen(point, instance);
        click = new MouseEvent(instance, MouseEvent.MOUSE_CLICKED, time, 0, buttonX, buttonY, point.x, point.y, 1,
                false,
                MouseEvent.BUTTON1);

        instance.dispatchEvent(click);

        assertTrue(Game.State == Game.STATE.WIN);
    }

    @Test
    public void clickQuit() {
        int buttonY = menu.quitY;
        point = new Point(buttonX, buttonY);
        time = System.currentTimeMillis();

        SwingUtilities.convertPointToScreen(point, instance);
        click = new MouseEvent(instance, MouseEvent.MOUSE_CLICKED, time, 0, buttonX,
                buttonY, point.x, point.y, 1,
                false,
                MouseEvent.BUTTON1);
        // instance.dispatchEvent(click);
        // assertThat().isEqualTo(0);
    }

}
