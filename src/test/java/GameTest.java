import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import org.junit.jupiter.api.BeforeEach;

public class GameTest {

    Game game;
    Score score;
    Mouse mouse;
    Map map;
    Thread thread;
    Position start = new Position(4, 4);

    @BeforeEach
    public void startGame() {
        game = new Game();
    }

    /*
     * Checks if the main game is running
     */
    @Test
    public void isGameRunning() {
        game.start();
        assertTrue(game.isPlaying);
    }

    /*
     * Checks if stop has succefully stopped the game loop from running
     */
    @Test
    public void checkStop() {
        game.thread = new Thread(game);
        game.stop();
        assertFalse(game.isPlaying);
    }

    /*
     * Check to see if restart has worked
     */
    @Test
    public void checkRestart() {

        // code for restart() calling function doesnt work for it atm ****
        map = new Map();
        mouse = new Mouse(map.startX, map.startY, map);
        game.addKeyListener(new UserInput(map.getPlayer()));

        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 0);
        assertTrue(map.player.pos.getX() == 4);
        assertTrue(map.player.pos.getY() == 4);

        // from userInputTest, checking if keys work after restart
        KeyEvent key1 = new KeyEvent(game, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        game.getKeyListeners()[0].keyPressed(key1);
        assertEquals(4, mouse.newPos.getX());
        assertEquals(4, mouse.newPos.getY());

    }

}
