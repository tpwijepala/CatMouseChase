package main.java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.awt.Point;

public class Menu extends MouseAdapter {
    public boolean mainMenu; // if main menu is displaying
    public Rectangle playButton = new Rectangle(Game.WIDTH / 2 + 120, 150, 100, 50);
    private boolean pHighlight = false; // true if the mouse hovered over the Play button

    public Rectangle helpButton = new Rectangle(Game.WIDTH / 2 + 120, 250, 100, 50);
    private boolean hHighlight = false;

    public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 + 120, 350, 100, 50);
    private boolean qHighlight = false;

    public void draw(Graphics g) {
        mainMenu = true;
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);

        g.drawString("TESTING", Game.WIDTH / 2 + 50, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.setColor(Color.black);
        if (pHighlight) {
            g.setColor(Color.white);
        }
        g.drawString("Play", playButton.x + 19, playButton.y + 30);

        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt2);
        if (hHighlight)
            g.setColor(Color.RED);
        g.drawString("Help", helpButton.x + 19, helpButton.y + 30);

        Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt3);
        if (qHighlight)
            g.setColor(Color.RED);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);

        g.setColor(Color.white);
        g2d.draw(playButton);
        g2d.draw(helpButton);
        g2d.draw(quitButton);
    }

    public void win(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("YOU WIN!", 100, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play Again", playButton.x + 19, playButton.y + 30);
        g2d.draw(playButton);

        Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
        g2d.draw(quitButton);
    }

    public void lose(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);
        g.setColor(Color.white);
        g.drawString("GAME OVER!", 100, 100);

        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g.drawString("Play Again?", playButton.x + 19, playButton.y + 30);
        g2d.draw(playButton);

        Font fnt3 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt3);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
        g2d.draw(quitButton);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        Point p = e.getPoint();

        if (Game.State == Game.STATE.MENU || Game.State == Game.STATE.WIN || Game.State == Game.STATE.LOSE) {
            if (playButton.contains(p))
                Game.State = Game.STATE.GAME;

            else if (quitButton.contains(p))
                System.exit(0);

            else if (helpButton.contains(p))
                Game.State = Game.STATE.LOSE;
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        Point p = e.getPoint();

        // determine if mouse is hovering inside one of the buttons
        pHighlight = playButton.contains(p);
        qHighlight = quitButton.contains(p);
        hHighlight = helpButton.contains(p);

    }

}
