import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

class GameTimer {
    //https://www.overclock.net/threads/making-a-countup-timer-in-java.1335918/
    // Timer gameTime = new Timer();
    // TimerTask startTime = new TimerTask;

    private long delay;  //in nanoseconds; equates to 1 sec delay
    private long timerCount;
    private long startCount;

    public GameTimer() {
        this.startCount = System.currentTimeMillis();
        this.timerCount = 0; 
        this.delay = 1000;   
    }

    //Restart the clock
    void setTime() {
        this.timerCount = this.startCount - System.currentTimeMillis();
        //gameTime.schedule(startTime, 0, delay);
    }

    String getTime() {
        return String.valueOf(timerCount);
    }

    //TODO: check graphics implementation
    void displayTime(Graphics g) {
        g.drawString(getTime(), 225, 30);
        //display the number
    }

}