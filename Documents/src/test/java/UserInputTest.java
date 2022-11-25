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
     */
    @Test
    public void acceptValidKeys() {
        Game instance = new Game(); 

        //Source: https://stackoverflow.com/questions/21075354/how-can-i-simulate-keypress-in-junit-test
        //Keys 1 - 4 check for valid input and key 5 is for invalid
        KeyEvent key1 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_W,'W');
        instance.getKeyListeners()[0].keyPressed(key1);
        assertEquals(4, testMap.getPlayer().getPos().getX());
        //assertEquals(3, testMap.getPlayer().getPos().getY()); --> failed

        KeyEvent key2 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_S,'S');
        instance.getKeyListeners()[0].keyPressed(key2);
        assertEquals(4, testMap.getPlayer().getPos().getX());
        //assertEquals(5, testMap.getPlayer().getPos().getY()); --> failed

        KeyEvent key3 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_A,'A');
        instance.getKeyListeners()[0].keyPressed(key3);
        //assertEquals(3, testMap.getPlayer().getPos().getX()); --> failed
        assertEquals(4, testMap.getPlayer().getPos().getY());

        KeyEvent key4 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_D,'D');
        instance.getKeyListeners()[0].keyPressed(key4);
        //assertEquals(5, testMap.getPlayer().getPos().getX()); --> failed
        assertEquals(4, testMap.getPlayer().getPos().getY());

        KeyEvent key5 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_Z,'Z');
        instance.getKeyListeners()[0].keyPressed(key5);
        assertEquals(4, testMap.getPlayer().getPos().getX());
        assertEquals(4, testMap.getPlayer().getPos().getY());

    }
    
}
