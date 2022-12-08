import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;

/**
 * Class encapsulates all of Game
 * <p>
 * Contains everything to run the game, render the graphics and manage objects
 * 
 * @author Ethan Phan
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1450;
    public static final int HEIGHT = 1025;
    public static final int SCALE = 1;
    public final String TITLE = "PROJECT TEST";

    public static boolean isPlaying = false;
    public static boolean programRunning = true;
    public Thread thread;
    Image background;

    private Menu menu;
    Map map;

    Mouse mouse;

    public enum STATE {
        MENU,
        GAME,
        WIN,
        LOSE
    }

    public static STATE State = STATE.MENU;

    /**
     * Creates Game with specifications and initialization
     */
    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        new Window("276 Project", this);
        map = new Map();
        this.addKeyListener(new UserInput(map.getPlayer()));

        menu = new Menu();
        this.addMouseListener(menu);

        try {
            background = ImageIO.read(new File("src/main/resources/menu.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new thread and starts the game
     */
    public synchronized void start() {

        thread = new Thread(this);

        thread.start();
        isPlaying = true;
    }

    /**
     * Stops the thread and stops the game
     */
    public void stop() {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Renders the graphics by calling in the other classes
     */
    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(background, 0, 0, null);

        if (State == STATE.MENU) {
            menu.drawMenu(g);
        }
        if (State == STATE.GAME) {
            isPlaying = true;
            map.drawEntities(g);

        }
        if (State == STATE.LOSE) {
            isPlaying = false;
            menu.lose(g);
        }
        if (State == STATE.WIN) {
            isPlaying = false;
            menu.win(g);
        }
        g.dispose();
        bs.show();
    }

    /**
     * Reinitializes the game after called
     */
    public void restart() {

        map = new Map();
        mouse = new Mouse(map.startX, map.startY, map);
        this.addKeyListener(new UserInput(map.getPlayer()));
        menu = new Menu();
        this.addMouseListener(menu);

    }

    /**
     * Running game loop that allows the game to work
     */
    @Override
    public void run() {
        // Run code obtained from
        // https://github.com/AzizZayed/Simple-Pong/blob/master/src/com/main/Game.java\
        // Also from other resources online

        // for testing purposes
        this.requestFocus();

        // game timer
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();

        do {
            // if program is running do
            if (State == STATE.LOSE || State == STATE.WIN) {
                restart();
                draw();

            }
            while (isPlaying) {

                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                if (delta >= 1) {

                    delta--;
                    draw();

                }

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;

                }
            }

        } while (programRunning);
        stop();

    }

    /**
     * Main method, start of the game
     */
    public static void main(String[] args) {

        Game game = new Game();
        game.start();

    }

}
