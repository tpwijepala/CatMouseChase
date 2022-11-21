import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MouseTest {
    Map map;
    Position pos = new Position(1, 1);

    @BeforeEach
    public void resetMap() {
        map = new Map();
        Game.State = Game.STATE.GAME;

        // Position for testing collection of objects should be empty by default
        map.removeItem(new Crumb(1, 1));
    }

    @Test
    public void checkAtFinishNotAllCrumbs() {
        map.crumbsCollect = 3;
        map.player.pos = new Position(map.endX, map.endY);
        map.player.checkFinish();
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public  void checkAtFinishWithAllCrumbs() {
        map.crumbsCollect = 4;
        map.player.pos = new Position(map.endX, map.endY);
        map.player.checkFinish();
        // check game state
        assertTrue(Game.State == Game.STATE.WIN);
    }

    @Test
    public void checkNotFinish() {
        map.player.pos = new Position(map.endX - 1, map.endY - 1);
        map.player.checkFinish();
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }


    @Test
    public void noItemToCollect() {
        // make sure there is no item to collect
        assertTrue(Map.getItem(pos) == null);
        map.player.pos = pos;
        map.player.collectItem();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 0);
    }

    @Test
    public void collectTrapToNotLose() {
        map.addItem(new MouseTrap(1, 1));
        map.player.pos = pos;
        map.player.getMouseScore().setScore(1);
        map.player.collectItem();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 0);
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
        // check if item was removed
        assertTrue(Map.getItem(pos) == null);
    }

    @Test
    public void collectTrapToLose() {
        map.addItem(new MouseTrap(1, 1));
        map.player.pos = pos;
        map.player.collectItem();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == -1);
        // check game state
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    @Test
    public void collectCrumb() {
        map.addItem(new Crumb(1, 1));
        map.player.pos = pos;
        map.player.collectItem();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 1);
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public void collectCheese() {
        map.addItem(new Cheese(1, 1));
        map.player.pos = pos;
        map.player.collectItem();
        System.out.println(map.player.getMouseScore().getScore());
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 2);
        // check game state
        //assertTrue(Game.State == Game.STATE.GAME);
    }
}