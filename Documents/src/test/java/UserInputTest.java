import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Robot;  //Need this to simulate key presses
import java.awt.event.KeyEvent;

public class UserInputTest{
    /**
     * Only tests moving the mouse if user presses W,A,S,D
     * and making sure the mouse is stationary at any other
     * inputs
     * 
     * Fake the input on the keyboard
     * UNIT TEST?
     */
    @Test
    public void acceptValidKeys() {
        //Robot testRobot = new Robot();

        // Simulate a key press
        //testRobot.keyPress(KeyEvent.VK_W);
        //testRobot.keyRelease(KeyEvent.VK_W);

        //assertEquals(KeyEvent.VK_W, testRobot.keyPress(KeyEvent.VK_W));
    }

    /**
     * Test to see if cat moves only if valid keys are pressed
     * INTEGRATION TEST
     */
    @Test
    public void moveCat() {}
    
}
