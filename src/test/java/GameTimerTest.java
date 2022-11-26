import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import android.view.Display;

public class GameTimerTest {
    Map map;

    @BeforeEach
    public void resetMap(){
        map = new Map();
        Game.State = Game.STATE.GAME;
    }

    @Test
    public void timer(){
        GameTimer time = new GameTimer();
        time.setTime();
        time.displayTime();
    }
}
