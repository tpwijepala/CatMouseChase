import java.awt.Font;
import java.awt.Graphics;

/**
 * @author Thimira Wijepala
 * @version 1.0
 */
class GameTimer {

    private long timerCount;
    private long startCount;

    /**
     * Instantiates the game clock to start counting up from
     * the current time by 1 sec (1000 milliseconds)
     */
    public GameTimer() {
        this.startCount = System.currentTimeMillis();
        this.timerCount = 0; 
    }

    //Restart the clock
    void setTime() {
        this.timerCount = System.currentTimeMillis() - this.startCount;
    }

    /**
     * Return the string that displays the time as hours:minutes:seconds
     * 
     * @return      hours:mins:sec format as a string
     */
    String displayTime() {
        setTime();
        long seconds = this.timerCount/1000;
        long mins = seconds/60;
        seconds = seconds%60;
        long hours = mins/60;
        mins = mins%60;
        return (Long.toString(hours) + ":" + Long.toString(mins) + ":" + Long.toString(seconds));
    }  


    /**
     * Prints the current time from {@link displayTime()} on the timer box
     * inside the GUI 
     * @param g     Graphics object used to draw the time
     */
    void displayTime(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 45));
        g.drawString(displayTime(), 475, 75);
    }

}