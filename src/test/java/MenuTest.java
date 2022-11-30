import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.SwingUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.junit.contrib.java.lang.system.Assertion;

public class MenuTest {
    Menu menu;
    int buttonX = Game.WIDTH / 2 - 300 / 2;
    MouseEvent press, release, click;
    Point point;
    long time;
    Game instance;

    /*
     * Using System Rules to catch System.Exit when it is called from
     * https://stefanbirkner.github.io/system-rules/index.html
     */
    @Rule
    public final ExpectedSystemExit exitRule = ExpectedSystemExit.none();

    @BeforeEach
    public void resetMenu() {

        instance = new Game();
        menu = new Menu();
        Game.State = Game.STATE.MENU;

    }

    /**
     * Test that play button has been clicked
<<<<<<< HEAD
=======
     * INTEGRATION TEST
>>>>>>> master
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

    /*
     * Test that help button has been clicked
<<<<<<< HEAD
=======
<<<<<<<< HEAD:Documents/src/test/java/MenuTest.java
========
     * INTEGRATION TEST
>>>>>>>> master:src/test/java/MenuTest.java
>>>>>>> master
     */
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

    /*
     * Test that checks if quit has been clicked **
<<<<<<< HEAD
=======
<<<<<<<< HEAD:Documents/src/test/java/MenuTest.java
========
     * INTEGRATION TEST
>>>>>>>> master:src/test/java/MenuTest.java
>>>>>>> master
     */
    @Test
    public void clickQuit() {

        exitRule.expectSystemExit();
        int buttonY = menu.quitY;
        point = new Point(buttonX, buttonY);
        time = System.currentTimeMillis();

        SwingUtilities.convertPointToScreen(point, instance);
        click = new MouseEvent(instance, MouseEvent.MOUSE_CLICKED, time, 0, buttonX,
                buttonY, point.x, point.y, 1,
                false,
                MouseEvent.BUTTON1);

        exitRule.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() {
                assertEquals("Exiting..", menu.message);
            }
        });
        // instance.dispatchEvent(click);

    }

}
