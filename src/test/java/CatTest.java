import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CatTest {
    Map testMap = new Map();
    Mouse testMouse = testMap.getPlayer();
    Cat testCat = (Cat) testMap.getCharacter(new Position(12, 34));
    Cat adjacentCat1 = (Cat) testMap.getCharacter(new Position(36, 24));
    Cat adjacentCat2 = (Cat) testMap.getCharacter(new Position(43, 13));

    @BeforeEach
    public void resetMap() {
        Game.State = Game.STATE.GAME;
    }

    /**
     * Tests when Mouse is in the same position as Cat
     * before Cat moves
     */
    
    @Test
    public void MouseOnTop() {
        
        testMouse.newPos = new Position(12, 34);
        testMouse.move(testMouse.newPos);
        
        testCat.catchMouse(testMouse.getPos());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test when Mouse is far away
     */
    @Test
    public void MouseFarAway() {
        
        testCat.catchMouse(testMouse.getPos());
        
        assertFalse(testCat.getPos().getX() == testMouse.getPos().getX());
        assertFalse(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.GAME);
    }
    

    /**
     * Test mouse collision in Y position
     */
    @Test
    public void MouseNextCellUp() {
        testMouse.newPos = new Position(12, 33);
        testMouse.move(testMouse.newPos);

        testCat.catchMouse(testMouse.getPos());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test mouse collision in X position
     */
    @Test
    public void MouseNextCellSide() {
        testMouse.newPos = new Position(11, 34);
        testMouse.move(testMouse.newPos);

        testCat.catchMouse(testMouse.getPos());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test Cat movement when Mouse is diagonally from it
     */
    @Test
    public void MouseDiagonal() {
        testMouse.newPos = new Position(11, 33);
        testMouse.move(testMouse.newPos);

        testCat.catchMouse(testMouse.getPos());
        assertTrue(Game.State == Game.STATE.GAME);
    }


    /**
     * Test Cat movement when there is a wall between it
     * and the mouse
     */
    @Test
    public void MouseOtherSideOfWall() {
        testMouse.newPos = new Position(14, 34);
        testMouse.move(testMouse.newPos);

        testCat.catchMouse(testMouse.getPos());

        assertFalse(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public void CatMoveToPreviousPosition() {
        //Put the mouse on the other side of a wall relative to the cat
        testMouse.newPos = new Position(14, 34);
        testMouse.move(testMouse.newPos);

        testMouse.newPos = new Position(14, 33);
        testMouse.move(testMouse.newPos);
        
        testCat.catchMouse(testMouse.getPos());
        System.out.println("CAT MOVE TO PREVIOUS POSITION: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());
        
        testMouse.newPos = new Position(14, 34);
        testMouse.move(testMouse.newPos);
        testCat.catchMouse(testMouse.getPos());
        System.out.println("CAT MOVE TO PREVIOUS POSITION: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());
        
        assertTrue(testCat.getPos().getX() == 12);
        assertTrue(testCat.getPos().getY() == 34);
        assertTrue(Game.State == Game.STATE.GAME);  

    }

    @Test
    public void CatInNextCell() {
        adjacentCat1.move(new Position(23, 27));
        adjacentCat2.move(new Position(24, 27));

        assertFalse(adjacentCat1.checkValidMove(new Position(24, 27)));
        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public void CatAtEdgeOfMapX() {
        testCat.move(new Position(57, 36));

        assertFalse(testCat.checkValidMove(new Position(58, 36)));
        assertTrue(Game.State == Game.STATE.GAME);
    }

    @Test
    public void CatAtEdgeOfMapY() {
        testCat.move(new Position(57, 40));

        assertFalse(testCat.checkValidMove(new Position(57, 41)));
        assertTrue(Game.State == Game.STATE.GAME);
    }
}

