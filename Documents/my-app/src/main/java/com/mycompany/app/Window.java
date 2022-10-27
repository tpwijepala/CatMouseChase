
package com.mycompany.app;

import javax.swing.JFrame;

public class Window {

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
