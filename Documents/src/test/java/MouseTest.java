import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MouseTest {
    //for each?
    Map map = new Map();

    @Test
    public void checkAtFinishNotAllCrumbs() {
        map.crumbsCollect = 4;
        map.player.pos = new Position(map.endX, map.endY);
        map.player.checkFinish();
        assertTrue(Game.State == Game.State.WIN);
    }

    @Test
    public  void checkAtFinishWithAllCrumbs() {

    }

    @Test
    public void checkNotFinish() {

    }
}