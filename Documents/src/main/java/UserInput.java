package main.java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class UserInput extends KeyAdapter {
    Mouse player;
    public UserInput(Mouse player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent input) {
        int key = input.getKeyCode();
        if (key == KeyEvent.VK_W) {  // Move UP
            player.move(new Position(player.pos.getX(), player.pos.getY() - 1));
            player.collectItem();
        }
        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.move(new Position(player.pos.getX(), player.pos.getY() + 1));
            player.collectItem();
        }
        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.move(new Position(player.pos.getX() - 1, player.pos.getY()));
            player.collectItem();
        }
        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.move(new Position(player.pos.getX() + 1, player.pos.getY()));
            player.collectItem();
        }

    }
}