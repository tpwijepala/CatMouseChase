import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CheeseTest {
    Map map = new Map();
    Cheese testCheese = new Cheese(5, 10, map);

    /**
     * Test that cheese is being generated on the screen.
     * UNIT TEST
     * TODO: write unit tests for the methods called in the posAvail
     */
    @Test
    public void checkNewPositionBounds() {
        assertTrue(testCheese.generatePosition().getX() < 1450);
        assertTrue(testCheese.generatePosition().getY() < 1025);
        assertTrue(testCheese.generatePosition().getX() > 0);
        assertTrue(testCheese.generatePosition().getY() > 0);
    }

    /**
     * Test that cheese is not spawning on top of other 
     * objects or characters
     * UNIT TEST
     */
    @Test
    public void checkPoints() {
        assertEquals(2, testCheese.getPoints());
    }

}
