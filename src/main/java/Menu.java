import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.*;

/*
 * This class encapsulates the Menu UI for the game
 * 
 * @author Ethan
 */
public class Menu extends MouseAdapter {

    String font = "DialogInput";
    Map map;
    Game game;
    Image p1, p2, p3;
    Image b1, b2;
    int playY = 150;
    int helpY = 250;
    int quitY = 350;
    int buttonWidth = 300;
    int heightWidth = 50;
    public static String message;

    public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 300 / 2, playY, buttonWidth, heightWidth);
    private boolean pHighlight = false; // true if the mouse hovered over the Play button

    public Rectangle helpButton = new Rectangle(Game.WIDTH / 2 - 300 / 2, helpY, buttonWidth, heightWidth);
    private boolean hHighlight = false;

    public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 300 / 2, quitY, buttonWidth, heightWidth);
    private boolean qHighlight = false;

    /*
     * Renders the main menu to the game screen
     * 
     * @param g Graphics library for customizing the menu
     */
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        // Font fnt0 = new Font(font, Font.BOLD, 50);
        // g.setFont(fnt0);
        // g.setColor(Color.white);

        // g.drawString("276 Project", Game.WIDTH / 2 - 150, 100);
        try {
            p1 = ImageIO.read(new File("src/main/resources/title.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.drawImage(p1, Game.WIDTH / 4 - 150, 0, null);

        Font fnt1 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        if (pHighlight) {
            g.setColor(Color.white);
        }
        g.drawString("Play", playButton.x + 100, playButton.y + 30);

        Font fnt2 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt2);
        if (hHighlight)
            g.setColor(Color.RED);
        g.drawString("Help", helpButton.x + 100, helpButton.y + 30);

        Font fnt3 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt3);
        if (qHighlight)
            g.setColor(Color.RED);
        g.drawString("Quit", quitButton.x + 100, quitButton.y + 30);

        g.setColor(Color.black);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
    }

    /*
     * Renders the win screen at end of game
     * 
     * @param g Graphics library for customizing the menu
     */
    public void win(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            p2 = ImageIO.read(new File("src/main/resources/win.png"));
            b1 = ImageIO.read(new File("src/main/resources/win1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(b1, 0, 0, null);
        g.drawImage(p2, Game.WIDTH / 2 - 175, 0, null);
        Font fnt1 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("Play Again", playButton.x + 100, playButton.y + 30);

        Font fnt3 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 100, quitButton.y + 30);

        g.setColor(Color.black);
        g2d.draw(playButton);
        g2d.draw(quitButton);
    }

    /*
     * Renders game over screen if you lose
     * 
     * @param g Graphics library for customizing the menu
     */
    public void lose(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        try {
            p3 = ImageIO.read(new File("src/main/resources/lose.png"));
            b2 = ImageIO.read(new File("src/main/resources/lose1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(b2, 0, 0, null);
        g.drawImage(p3, Game.WIDTH / 3 - 50, 0, null);
        Font fnt1 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("Play Again?", playButton.x + 70, playButton.y + 30);

        Font fnt3 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 100, quitButton.y + 30);

        g.setColor(Color.black);
        g2d.draw(playButton);
        g2d.draw(quitButton);
    }

    /*
     * Allows mouse input, allows user to click the menu buttons
     * 
     * @param e MouseEvent, checks to see if a mouse click has happened
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        Point p = e.getPoint();

        if (Game.State == Game.STATE.MENU || Game.State == Game.STATE.WIN || Game.State == Game.STATE.LOSE) {
            if (playButton.contains(p)) {
                Game.State = Game.STATE.GAME;
            } else if (quitButton.contains(p)) {
                message = "Exiting..";
                System.exit(0);
            }

            else if (helpButton.contains(p))
                Game.State = Game.STATE.WIN;
        }

    }

    /*
     * Checks if mouse is being moved and not being pressed,
     * 
     * @param e the mouse movement
     */
    @Override
    public void mouseMoved(MouseEvent e) {

        Point p = e.getPoint();

        // determine if mouse is hovering inside one of the buttons
        pHighlight = playButton.contains(p);
        qHighlight = quitButton.contains(p);
        hHighlight = helpButton.contains(p);

    }

}
