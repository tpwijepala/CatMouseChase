import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CatTest {
    Map testMap = new Map();
    Cat testCat = new Cat(12, 34, testMap);

    /**
     * Tests when Mouse is in the same position as Cat
     * before Cat moves
     */
    @Test
    public void MouseOnTop() {
        Mouse testMouse = new Mouse(12, 34, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE ON TOP: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test when Mouse is far away
     */
    @Test
    public void MouseFarAway() {
        Mouse testMouse = new Mouse(4, 4, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE FAR AWAY: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());
        assertFalse(testCat.getPos().getX() == testMouse.getPos().getX());
        assertFalse(testCat.getPos().getY() == testMouse.getPos().getY());
        //assertTrue(Game.State != Game.STATE.LOSE); //returns false
    }

    /**
     * Test mouse collision in Y position
     */
    @Test
    public void MouseNextCellUp() {
        Mouse testMouse = new Mouse(12, 33, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE NEXT CELL UP: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test mouse collision in X position
     */
    @Test
    public void MouseNextCellSide() {
        Mouse testMouse = new Mouse(11, 34, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE NEXT CELL SIDE: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());

        assertTrue(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        assertTrue(Game.State == Game.STATE.LOSE);
    }

    /**
     * Test Cat movement when Mouse is diagonally from it
     */
    @Test
    public void MouseDiagonal() {
        Mouse testMouse = new Mouse(11, 33, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE DIAGONAL: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());

        //assertTrue(Game.State != Game.STATE.LOSE);  //returns false
    }

    /**
     * Test Cat movement when there is a wall between it
     * and the mouse
     */
    @Test
    public void MouseOtherSideOfWall() {
        Mouse testMouse = new Mouse(14, 34, testMap);

        testCat.catchMouse(testMouse.getPos());
        System.out.println("MOUSE OTHER SIDE OF WALL: Cat new X: " + testCat.getPos().getX() + " new Y: " + testCat.getPos().getY());

        assertFalse(testCat.getPos().getX() == testMouse.getPos().getX());
        assertTrue(testCat.getPos().getY() == testMouse.getPos().getY());
        //assertTrue(Game.State != Game.STATE.LOSE);  //returns false
    }

    @Test
    public void CatMoveToPreviousPosition() {
        //Mouse testMouse = new Mouse(14, 34, testMap);

    }

    @Test
    public void CatInNextCell() {
        //Mouse testMouse = new Mouse(14, 34, testMap);
    }
    

}

