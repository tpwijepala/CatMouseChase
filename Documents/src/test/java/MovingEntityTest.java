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
        map.player.pos = pos;
    }

    @Test
    public void checkMoveNoChange() {
        map.player.move(pos);
        // check position remains the same
        assertTrue(map.player.pos.getX() == 4);
        assertTrue(map.player.pos.getY() == 4);
    }

    @Test
    public void checkMoveX() {
        map.player.move(new Position(5, 4));
        // check only X changed
        assertTrue(map.player.pos.getX() == 5);
        assertTrue(map.player.pos.getY() == 4);
    }

    @Test
    public void checkMoveY() {
        map.player.move(new Position(4, 5));
        // check only Y changed
        assertTrue(map.player.pos.getX() == 4);
        assertTrue(map.player.pos.getY() == 5);
    }

    @Test
    public void checkMoveXAndY() {
        map.player.move(new Position(5, 5));
        // check both X and Y changed
        assertTrue(map.player.pos.getX() == 5);
        assertTrue(map.player.pos.getY() == 5);
    }


    @Test
    public void moveIntoWall() {
        // Position (0, 0) contains a wall
        assertTrue(map.isWall(0, 0) == 1);
        assertFalse(map.player.checkValidMove(new Position(0, 0)));
    }

    @Test
    public void moveOutOfBoundsHigh() {
        // Corner of map: (57, 41)
        assertFalse(map.player.checkValidMove(new Position(58, 41)));
        assertFalse(map.player.checkValidMove(new Position(57, 42)));
        assertFalse(map.player.checkValidMove(new Position(58, 42)));
    }

    @Test
    public void moveOutOfBoundsLow() {
        // Corner of map: (0, 0)
        assertFalse(map.player.checkValidMove(new Position(-1, 0)));
        assertFalse(map.player.checkValidMove(new Position(0, -1)));
        assertFalse(map.player.checkValidMove(new Position(-1, -1)));
    }

    @Test
    public void moveValid() {
        // Position (5, 5) does not contain a wall
        assertTrue(map.isWall(5, 5) == 0);
        assertTrue(map.player.checkValidMove(new Position(5, 5)));
    }
}