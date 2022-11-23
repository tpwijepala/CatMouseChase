
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Color;

/*
 * Class encapsulates all of Game
 * <p>
 * Contains everything to run the game, render the graphics and manage objects
 * 
 * @author Ethan
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1450;
    public static final int HEIGHT = 1025;
    public static final int SCALE = 1;
    public final String TITLE = "CAT AND MOUSE CHASE";

    private boolean isPlaying = false;
    private Thread thread;

    // private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
    // BufferedImage.TYPE_INT_RGB);

    private Menu menu;
    Map map = new Map();

    public enum STATE {
        MENU,
        GAME,
        WIN,
        LOSE
    }

    public static STATE State = STATE.MENU;

    /*
     * Creates Game with specifications and initialization
     */
    public Game() {
        this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        this.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        new Window("WELCOME TO: CAT AND MOUSE CHASE", this);

        this.addKeyListener(new UserInput(map.getPlayer()));

        menu = new Menu();
        this.addMouseListener(menu);
        this.addMouseListener(menu);

    }

    /*
     * Creates a new thread and starts the game
     */
    public synchronized void start() {

        thread = new Thread(this);

        thread.start();
        isPlaying = true;
    }

    /*
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

    /*
     * Renders the graphics by calling in the other classes
     */
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
        }
        if (State == STATE.GAME) {
            map.drawEntities(g);
        }
        if (State == STATE.WIN) {
            menu.win(g);
        }
        if (State == STATE.LOSE) {
            menu.lose(g);
        }
        
        g.dispose();
        bs.show();
    }

    /*
     * Creates the background for game
     */
    private void drawBackground(Graphics g) {
        // black background
        g.setColor(Color.blue);
        g.fillRect(0, 0, 1450, 1025);

    }

    /*
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
        // int frames = 0;
        while (isPlaying) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {

                delta--;
                draw();
                // frames++;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                // frames = 0;
            }
        }

        stop();
    }

    /**
    * Main method, start of the game
    */
    public static void main(String[] args) {
        System.out.println("Game loading...");
        Game game = new Game();
        game.start();

    }

}
