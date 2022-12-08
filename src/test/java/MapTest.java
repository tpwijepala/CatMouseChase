import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class MapTest {
    Map map;

    @BeforeEach
    public void resetMap(){
        map = new Map();
        Game.State = Game.STATE.GAME;
    }

    //UNIT TEST
    @Test
    public void testGenerations(){
        assertTrue(map.getObjectsArray().size() == 21);
        assertTrue(map.items.size() == 17);
        
        assertTrue(map.characters.size() == 4);
    }

    //UNIT TEST
    @Test
    public void testWalls(){
        assertTrue(map.isWall(0, 3) == 0);
        assertTrue(map.isWall(0, 0) == 1);
    }

    //UNIT TEST
    @Test
    public void testNaturalCheeseGen(){
        long timeSpawn = System.currentTimeMillis();
        map = new Map(); // reset start time
        map.cheeseExist(false);
        while(!map.cheeseExists) {map.cheeseExist(false);};
        timeSpawn = System.currentTimeMillis() - timeSpawn;
        long timeDespawn = System.currentTimeMillis();
        while(map.cheeseExists) {map.cheeseExist(false);};
        timeDespawn = System.currentTimeMillis() - timeDespawn;
        
        assertTrue(timeSpawn >= 5000);
        assertTrue(timeDespawn >= 12000);
    }

    //UNIT TEST
    @Test
    public void testCheesePickUp(){
        while(!map.cheeseExists) {map.cheeseExist(false);};
        map.cheeseExist(true);
        long timeSpawn = System.currentTimeMillis();
        assertTrue(map.cheeseExists == false);
        while(!map.cheeseExists) {map.cheeseExist(false);};
        timeSpawn = System.currentTimeMillis() - timeSpawn;

        assertTrue(timeSpawn >= 5000);
        
    }

    //UNIT TEST
    @Test
    public void testTick(){
        while (!map.tick());
        long time = System.currentTimeMillis();
        assertTrue(map.tick() == false);
        while (!map.tick());
        time = System.currentTimeMillis() - time;
        assertTrue(time >= 250);
    }

    //UNIT TEST
    @Test
    public void testItems(){
        Crumb c = new Crumb(0, 5);
        assertTrue(map.getItem(new Position(0, 5)) == null);
        map.addItem(c);
        assertTrue(map.getItem(new Position(0, 5)) != null);
        map.removeItem(c);
        assertTrue(map.getItem(new Position(0, 5)) == null);
    }

    //UNIT TEST
    @Test
    public void testCharacters(){
        assertTrue(map.getCharacter(new Position(0, 5)) == null);

        map.addCharacter(new Cat(0, 5, map));
        assertTrue(map.getCharacter(new Position(0, 5)) != null);
        assertTrue(map.getPlayer() == map.getCharacter(new Position(4,4)));
    }
}
