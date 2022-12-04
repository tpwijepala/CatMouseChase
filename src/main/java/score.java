import java.awt.Font;
import java.awt.Graphics;

/**
 * @author: Karina Kramer
 * @version: 1.0
 */
class Score {

    private int playerScore;

    /**
     * Instantiates the Mouse's score to start at 0
     */
    public Score() {
        this.playerScore = 0;
    }

    /**
     * Increments or decrements the score
     * 
     * @param scoreChange       Number of points (can be positive or negative)
     */
    void setScore(int scoreChange) {
        playerScore += scoreChange;
    }

    String getScore() {
        return Integer.toString(playerScore);
    }

    Boolean checkScoreBelowZero() {
        if (playerScore < 0) {
            return true;
        }

        return false;
    }

    /**
     * Display the player's current score in the GUI
     * 
     * @param g     Graphics object used to draw this score
     */
    void displayScore(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 45));
        g.drawString(getScore(), 875, 75);
    }
}