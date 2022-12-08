import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class MouseTest {
    Map map;
    Position pos = new Position(4, 4);

    @BeforeEach
    public void resetMap() {
        map = new Map();
        Game.State = Game.STATE.GAME;
        map.player.getMouseScore().setScore(0 - Integer.parseInt(map.player.getMouseScore().getScore()));

        // Position for testing collection of objects should be empty by default
        map.removeItem(new Crumb(1, 1));
    }

    //UNIT TEST
    @Test
    public void checkAtFinishNotAllCrumbs() {
        map.crumbsCollect = 3;
        map.player.newPos = new Position(map.endX, map.endY);
        map.player.move();
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }

    //UNIT TEST
    @Test
    public  void checkAtFinishWithAllCrumbs() {
        map.crumbsCollect = 18;
        map.player.newPos = new Position(map.endX, map.endY+2);
        map.player.move();
        // check game state
        assertTrue(Game.State == Game.STATE.WIN);
    }

    //UNIT TEST
    @Test
    public void checkNotFinish() {
        map.player.newPos = new Position(map.endX, map.endY);
        map.player.move();
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }

    //UNIT TEST
    @Test
    public void noItemToCollect() {
        // make sure there is no item to collect
        map.player.newPos = pos;
        
        assertTrue(map.getItem(pos) == null);
        map.player.move();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 0);
    }

    //UNIT TEST
    @Test
    public void collectTrapToNotLose() {
        map.addItem(new MouseTrap(4, 4));
        map.player.newPos = new Position(4, 4);
        map.player.getMouseScore().setScore(1);
        map.player.move();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 0);
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
        // check if item was removed
        assertTrue(map.getItem(pos) == null);
    }

    //UNIT TEST
    @Test
    public void collectTrapToLose() {
        map.addItem(new MouseTrap(4, 4));
        map.player.newPos = pos;
        map.player.move();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == -1);
        // check game state
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    //UNIT TEST
    @Test
    public void collectCrumb() {
        map.addItem(new Crumb(4, 4));
        map.player.newPos = pos;
        map.player.move();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 1); 
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }

    //UNIT TEST
    @Test
    public void collectCheese() {
        Cheese c = new Cheese(map);
        map.addItem(c);
        map.player.pos = c.getPos();
        map.player.collectItem();
        // check score value
        assertTrue(Integer.parseInt(map.player.getMouseScore().getScore()) == 2);
        // check game state
        assertTrue(Game.State == Game.STATE.GAME);
    }
}
