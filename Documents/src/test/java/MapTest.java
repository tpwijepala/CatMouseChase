import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class MapTest {
    Map map;

    @BeforeEach
    public void resetMap(){
        map = new Map();
        Game.State = Game.STATE.GAME;
    }

    @Test
    public void testGenerations(){
        if (map.cheeseExists){
            assertTrue(map.getObjectsArray().size() == 12);
            assertTrue(map.items.size() == 8);
        }else{
            assertTrue(map.getObjectsArray().size() == 11);
            assertTrue(map.items.size() == 7);
        }
        assertTrue(map.characters.size() == 4);
    }

    @Test
    public void testWalls(){
        assertTrue(map.isWall(0, 3) == 0);
        assertTrue(map.isWall(0, 0) == 1);
    }

    @Test
    public void testCheese(){}

    @Test
    public void testTick(){
        while (!map.tick());
        long time = System.currentTimeMillis();
        assertTrue(map.tick() == false);
        while (!map.tick());
        time = System.currentTimeMillis() - time;
        assertTrue(time >= 1000);
    }

    @Test
    public void testItems(){
        Crumb c = new Crumb(0, 5);
        assertTrue(map.getItem(new Position(0, 5)) == null);
        map.addItem(c);
        assertTrue(map.getItem(new Position(0, 5)) != null);
        map.removeItem(c);
        assertTrue(map.getItem(new Position(0, 5)) == null);
    }

    @Test
    public void testCharacters(){
        assertTrue(map.getCharacter(new Position(0, 5)) == null);

        map.addCharacter(new Cat(0, 5, map));
        assertTrue(map.getCharacter(new Position(0, 5)) != null);
        assertTrue(map.getPlayer() == map.getCharacter(new Position(4,4)));
    }
}
