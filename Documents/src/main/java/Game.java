//package main.java;

// import java.Map;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Color;

/**
 * Hello world!
 *
 */

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 313;
    public static final int HEIGHT = 222;
    public static final int SCALE = 2;
    public final String TITLE = "PROJECT TEST";

    private boolean isPlaying = false;
    private Thread thread;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private Menu menu;
    Map map = new Map();

    public enum STATE {
        MENU,
        GAME,
        WIN,
        LOSE
    }

    public static STATE State = STATE.MENU;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        new Window("TESTIING", this);
        init();

        this.addKeyListener(new UserInput(map.getPlayer()));

    }

    private void init() {
        menu = new Menu();
        this.addMouseListener(menu);
        this.addMouseListener(menu);
    }

    // If method gets called again returns out of method
    public synchronized void start() {

        thread = new Thread(this);

        thread.start();
        isPlaying = true;
    }

    public void stop() {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        drawBackground(g);
        if (State == STATE.MENU) {
            menu.draw(g);
            menu.mainMenu = true;
        }
        if (State == STATE.GAME) {
            
            map.drawEntities(g);
            // menu.win(g);
        }
        if (State == STATE.LOSE) {
            menu.lose(g);
        }
        g.dispose();
        bs.show();
    }

    private void drawBackground(Graphics g) {
        // black background
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1000, 1000);

    }

    @Override
    public void run() {
        // so you can keep your sanity, I won't explain the game loop... you're welcome
        // I have a video on this game loop tho, check it out
        // Run code obtained from
        // https://github.com/AzizZayed/Simple-Pong/blob/master/src/com/main/Game.java
        // for testing purposes
        this.requestFocus();

        // game timer
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isPlaying) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                
                delta--;
                draw();
                frames++;
            }
            

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

        stop();
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Game game = new Game();
        game.start();

    }

}
