import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

public class PositionTest {
    Position testPos = new Position(5, 13);

    /*
    * Test the getters and setters
    * UNIT TEST
    */
    @Test
    public void setNewPosition() {
        testPos.setX(10);
        testPos.setY(23);

        assertEquals(10, testPos.getX());
        assertEquals(23, testPos.getY());
    }
    
}
