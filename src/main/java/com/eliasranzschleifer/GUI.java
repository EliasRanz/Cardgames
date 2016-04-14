package com.eliasranzschleifer;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUI extends JFrame {
    private final JFrame frame = new JFrame();
    private final int uiHeight,uiWidth;
    private final JButton exitButton = new JButton();
    private final JPanel panel = new JPanel();

    public GUI(int width,int height) {
        this.uiHeight = height;
        this.uiWidth = width;
        initUI();
    }

    private final void initUI() {
        this.setTitle("Card Game");
        this.setLocationRelativeTo(null);
        this.setSize(uiWidth,uiHeight);
        this.getContentPane().add(panel);
        this.setVisible(true);
        panel.setLayout(null);

        exitButton.setText("Exit");
        exitButton.setBounds(90,100,80,30);
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        frame.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
