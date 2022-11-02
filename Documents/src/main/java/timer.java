import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

class gameTimer {
    //https://www.overclock.net/threads/making-a-countup-timer-in-java.1335918/
    // Timer gameTime = new Timer();
    // TimerTask startTime = new TimerTask;

    private long delay;  //in nanoseconds; equates to 1 sec delay
    private long timerCount;

    public gameTimer() {
        this.timerCount = 0; 
        this.delay = 1000;   
    }

    //Restart the clock
    void setTime() {
        while (true) {
            timerCount++;
        }
        //gameTime.schedule(startTime, 0, delay);
    }

    Timer getTime() {
        return timerCount;
    }

    //TODO: check graphics implementation
    void displayTime() {
        this.getTime();
        //display the number
    }

    //toString new to Timer class
    public String toString() {
        return (" + timerCount + ");
    }

}