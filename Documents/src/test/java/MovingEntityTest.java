import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MovingEntityTest {
    Map map;
    Position pos = new Position(4, 4);
    // position (4, 4) has no walls surrounding it

    @BeforeEach
    public void resetMap() {
        map = new Map();
        Game.State = Game.State.GAME;
    }

    @Test
    public void checkMoveNoChange() {
        map.player.pos = pos;
        map.player.move(pos);
        // check position remains the same
        assertTrue(map.player.pos.getX() == 4);
        assertTrue(map.player.pos.getY() == 4);
    }

    @Test
    public void checkMoveX() {
        map.player.pos = pos;
        map.player.move(new Position(5, 4));
        // check only X changed
        assertTrue(map.player.pos.getX() == 5);
        assertTrue(map.player.pos.getY() == 4);
    }

    @Test
    public void checkMoveY() {
        map.player.pos = pos;
        map.player.move(new Position(4, 5));
        // check only Y changed
        assertTrue(map.player.pos.getX() == 4);
        assertTrue(map.player.pos.getY() == 5);
    }

    @Test
    public void checkMoveXAndY() {
        map.player.pos = pos;
        map.player.move(new Position(5, 5));
        // check both X and Y changed
        assertTrue(map.player.pos.getX() == 5);
        assertTrue(map.player.pos.getY() == 5);
    }


    @Test
    public void moveIntoWall() {

    }
}