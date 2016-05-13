package com.eliasranzschleifer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class GUI extends JFrame {
    private final JFrame frame = new JFrame();
    private final int uiHeight, uiWidth;
    private final JButton exitButton = new JButton("Exit");
    private final JButton blackjackButton = new JButton("Blackjack");
    private String getGameChoice;

    GUI(int width, int height) {
        this.uiHeight = height;
        this.uiWidth = width;
        gameMenu();
    }


    private void gameMenu() {
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(3,3));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(blackjackButton);
        frame.add(exitButton);
        frame.pack();
        frame.setVisible(true);
    }


}
