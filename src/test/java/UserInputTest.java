import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class UserInputTest{
    Game instance = new Game();
    
    /*
    * Only tests moving the mouse if user presses W,A,S,D
    * INTEGRATION TEST
    */
    @Test
    public void acceptValidKeys() {
        Mouse testPlayer = instance.map.getPlayer();

        //Source: https://stackoverflow.com/questions/21075354/how-can-i-simulate-keypress-in-junit-test
        KeyEvent key1 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_W,'W');
        instance.getKeyListeners()[0].keyPressed(key1);
        assertEquals(4, testPlayer.newPos.getX());
        assertEquals(3, testPlayer.newPos.getY()); 

        KeyEvent key2 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_S,'S');
        instance.getKeyListeners()[0].keyPressed(key2);
        assertEquals(4, testPlayer.newPos.getX());
        assertEquals(5, testPlayer.newPos.getY()); 

        KeyEvent key3 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_A,'A');
        instance.getKeyListeners()[0].keyPressed(key3);
        assertEquals(3, testPlayer.newPos.getX()); 
        assertEquals(4, testPlayer.newPos.getY());

        KeyEvent key4 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_D,'D');
        instance.getKeyListeners()[0].keyPressed(key4);
        assertEquals(5, testPlayer.newPos.getX()); 
        assertEquals(4, testPlayer.newPos.getY());

    }

    /*
    * Only tests if the mouse stays stationary at an invalid input
    * INTEGRATION TEST
    */
    @Test
    public void rejectInvalidKeys() {
        Mouse testPlayer = instance.map.getPlayer();

        KeyEvent key5 = new KeyEvent(instance, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0,  KeyEvent.VK_Z,'Z');
        instance.getKeyListeners()[0].keyPressed(key5);
        assertEquals(4, testPlayer.newPos.getX());
        assertEquals(4, testPlayer.newPos.getY());
    }
}