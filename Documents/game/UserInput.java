package game;

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
            player.pos = new Position(player.pos.getX(), player.pos.getY() - 1);
            System.out.println("U");
        }
        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.pos = new Position(player.pos.getX(), player.pos.getY() + 1);
            System.out.println("D");
        }
        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.pos = new Position(player.pos.getX() - 1, player.pos.getY());
            System.out.println("L");
        }
        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.pos = new Position(player.pos.getX() + 1, player.pos.getY());
            System.out.println("R");
        }

    }
}