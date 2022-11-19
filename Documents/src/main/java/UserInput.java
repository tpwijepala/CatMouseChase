//package main.java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.Boolean;

class UserInput extends KeyAdapter {
    Mouse player;
    Map gameMap = new Map();

    public UserInput(Mouse player) {
        this.player = player;
    }

    public void keyPressed(KeyEvent input) {
        int key = input.getKeyCode();
        boolean catMoveFlag = false;

        if (key == KeyEvent.VK_W) {  // Move UP
            player.newPos = (new Position(player.getPos().getX(), player.getPos().getY() - 1));
        }

        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.newPos = (new Position(player.getPos().getX(), player.getPos().getY() + 1));
        }

        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.newPos = (new Position(player.getPos().getX() - 1, player.getPos().getY()));
        }

        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.newPos = (new Position(player.getPos().getX() + 1, player.getPos().getY()));
        }

        
        if (catMoveFlag == false) {
            catMoveFlag = true; 

            //Based on where we added the cats in the objects array
            for (int i = 0; i < 3; i++) {
                Cat mapCat = Map.getCats().get(i);
                mapCat.startMove(player.getPos());
            }
        }
        
    }
}