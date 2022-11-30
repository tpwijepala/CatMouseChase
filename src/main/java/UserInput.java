//package main.java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.Boolean;

/*
 * Class encapsulates the input for movement
 * 
 * @author Robert, Thimira
 */
class UserInput extends KeyAdapter {
    Mouse player;

    /*
     * Sets the userinput to the player
     */
    public UserInput(Mouse player) {
        this.player = player;
    }

    /*
     * Moves the actor with input from keyboard
     */
    public void keyPressed(KeyEvent input) {
        int key = input.getKeyCode();

        if (key == KeyEvent.VK_W) {  // Move UP
            player.newPos = (new Position(player.getPos().getX(), player.getPos().getY() - 1));
            player.rotateMouse(0);
        }

        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.newPos = (new Position(player.getPos().getX(), player.getPos().getY() + 1));
            player.rotateMouse(2);
        }

        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.newPos = (new Position(player.getPos().getX() - 1, player.getPos().getY()));
            player.rotateMouse(1);
        }

        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.newPos = (new Position(player.getPos().getX() + 1, player.getPos().getY()));
            player.rotateMouse(3);
        }

    }
}