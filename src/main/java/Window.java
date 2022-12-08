import javax.swing.JFrame;

/**
 * This class encapsulates all the settings for creating the Game window
 * 
 * @author Ethan Phan
 */
public class Window {

    /**
     * Creates and opens the window with the specifications
     * 
     * @param title The title of the window
     * @param game  The game that we are applying these window specifications to
     */
    public Window(String title, Game game) {
        JFrame frame = new JFrame(title);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
