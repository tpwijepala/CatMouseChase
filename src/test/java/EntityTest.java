import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class EntityTest {
    Entity e;

    @BeforeEach
    public void resetEntity() {
        e = new Entity(1, 1);
    }

    //UNIT TEST
    @Test
    public void getPosition() {
        assertTrue(e.getPos().getX() == 1);
        assertTrue(e.getPos().getY() == 1);
    }

    //UNIT TEST
    @Test
    public void setPosNoChange() {
        e.getPos().setPos(e.getPos().getX(), e.getPos().getY());
        // check position remains the same
        assertTrue(e.getPos().getX() == 1);
        assertTrue(e.getPos().getY() == 1);
    }

    //UNIT TEST
    @Test
    public void setPosX() {
        e.getPos().setPos(5, e.getPos().getY());
        // check only X changed
        assertTrue(e.getPos().getX() == 5);
        assertTrue(e.getPos().getY() == 1);
    }

    //UNIT TEST
    @Test
    public void setPosY() {
        e.getPos().setPos(e.getPos().getX(), 5);
        // check only Y changed
        assertTrue(e.getPos().getX() == 1);
        assertTrue(e.getPos().getY() == 5);
    }

    //UNIT TEST
    @Test
    public void setPosXAndY() {
        e.getPos().setPos(5, 5);
        // check both X and Y changed
        assertTrue(e.pos.getX() == 5);
        assertTrue(e.pos.getY() == 5);
    }

}