import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Score {

    private int playerScore;

    public Score() {
        this.playerScore = 0;
    }

    //Named adjustScore in UML but I think it's better to make it setScore
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

    //TODO: check graphics implementation
    void displayScore(Graphics g) {
        //create(ScoreBoard)
        g.drawString(getScore(), 375, 30);
    }
}