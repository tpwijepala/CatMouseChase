import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Robot;  //Need this to simulate key presses
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class UserInputTest{
    Map testMap = new Map();
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
        Robot testRobot = new Robot();
        UserInput testUser = new UserInput(testMap.getPlayer());

        // Simulate a key press
        testRobot.keyPress(KeyEvent.VK_W);
        testRobot.keyRelease(KeyEvent.VK_W);  

        


        KeyEvent key = new KeyEvent(testUser, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        testUser.getKeyListeners()[0].keyPressed(key);
        //

        

        //assertEquals(KeyEvent.VK_W, testRobot.keyPressed(KeyEvent.VK_W));
    }
    
}
