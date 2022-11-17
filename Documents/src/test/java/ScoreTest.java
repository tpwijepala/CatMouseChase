import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
//package main.java;

public class ScoreTest {
    Score testScore = new Score();

    /**
     * Test if score increments and decrements
     */
    @Test
    public void adjustScore() {
        testScore.setScore(1);
        assertEquals("1", testScore.getScore());

        testScore.setScore(-1);
        assertEquals("0", testScore.getScore());
    }

    /**
     * Test if negative score detection works
     */
    @Test
    public void checkNegativeScore() {
        //Set score to -1
        testScore.setScore(-1);
        assertEquals(true, testScore.checkScoreBelowZero());

        //Set score to 0
        testScore.setScore(1);
        assertEquals(false, testScore.checkScoreBelowZero());

    }
}
