//package main.java;

import java.awt.Color;import import ava.aw

import ja
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import java.awt.Component;

/*
 * This class encapsulates the Menu UI for the game
 * 
 * @author Ethan
 */
public class Menu extends MouseAdapter {

    String font = "DialogInput";
    Map map;
    Game game;
    int playY = 150;
    int helpY = 250;
    int quitY = 350;
    int buttonWidth = 300;
    int heightWidth = 50;

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

        Font fnt0 = new Font(font, Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);

        g.drawString("276 Project", Game.WIDTH / 2 - 150, 100);

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

        g.setColor(Color.white);
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

        Font fnt0 = new Font(font, Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("YOU WIN!", Game.WIDTH / 2 - 100, 100);

        Font fnt1 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("Play Again", playButton.x + 100, playButton.y + 30);

        Font fnt3 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 100, quitButton.y + 30);

        g.setColor(Color.white);
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

        Font fnt0 = new Font(font, Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("GAME OVER!", Game.WIDTH / 2 - 100, 100);

        Font fnt1 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        g.drawString("Play Again?", playButton.x + 70, playButton.y + 30);

        Font fnt3 = new Font(font, Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 100, quitButton.y + 30);

        g.setColor(Color.white);
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
            } else if (quitButton.contains(p))
                System.exit(0);

            else if (helpButton.contains(p))
                Game.State = Game.STATE.LOSE;
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
