import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MouseTest {
    //for each?
    Map map;

    @BeforeEach
    public void resetMap() {
        map = new Map();
        Game.State = Game.State.GAME;
    }

    @Test
    public void checkAtFinishNotAllCrumbs() {

        map.crumbsCollect = 3;
        map.player.pos = new Position(map.endX, map.endY);
        map.player.checkFinish();
        assertTrue(Game.State == Game.State.GAME);
    }

    @Test
    public  void checkAtFinishWithAllCrumbs() {
        Map map = new Map();
        map.crumbsCollect = 4;
        map.player.pos = new Position(map.endX, map.endY);
        map.player.checkFinish();
        assertTrue(Game.State == Game.State.WIN);
    }

    @Test
    public void checkNotFinish() {
        Map map = new Map();
        map.player.pos = new Position(map.endX - 1, map.endY - 1);
        map.player.checkFinish();
        assertTrue(Game.State == Game.State.GAME);
    }
}