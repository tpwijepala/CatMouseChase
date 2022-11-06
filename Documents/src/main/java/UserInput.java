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
        System.out.println("CAT MOVE FLAG IS " + catMoveFlag);

        if (key == KeyEvent.VK_W) {  // Move UP
            player.move(new Position(player.getPos().getX(), player.getPos().getY() - 1));
        }

        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.move(new Position(player.getPos().getX(), player.getPos().getY() + 1));
        }

        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.move(new Position(player.getPos().getX() - 1, player.getPos().getY()));
        }

        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.move(new Position(player.getPos().getX() + 1, player.getPos().getY()));
        }

        if (catMoveFlag == false) {
            catMoveFlag = true; 
            System.out.println("CAT MOVE FLAG IS " + catMoveFlag);

            //Based on where we added the cats in the objects array
            //TODO: adjust loop index
            for (int i = 0; i < 3; i++) {
                Cat mapCat = Map.getCats().get(i);
                mapCat.startMove(player.getPos());
            }
        }

        player.collectItem();

    }
}