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
            System.out.println("U, " + player.pos);
        }
        else if (key == KeyEvent.VK_S) {  // Move DOWN
            player.move(new Position(player.pos.getX(), player.pos.getY() + 1));
            System.out.println("D, " + player.pos);
        }
        else if (key == KeyEvent.VK_A) {  // Move LEFT
            player.move(new Position(player.pos.getX() - 1, player.pos.getY()));
            System.out.println("L, " + player.pos);
        }
        else if (key == KeyEvent.VK_D) {  // Move RIGHT
            player.move(new Position(player.pos.getX() + 1, player.pos.getY()));
            System.out.println("R, " + player.pos);
        }

    }
}