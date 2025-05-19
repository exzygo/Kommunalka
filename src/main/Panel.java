package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Panel {

    Font normalFont = new Font("Monocraft", Font.PLAIN, 30);

    public JPanel titlePanel() {
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(100, 150, 600, 150);
        titlePanel.setBackground(new Color(0,0,0, 0));
        return titlePanel;
    }

    public JLabel titleLabel() {
        JLabel titleLabel = new JLabel("KOMMUNALKA");
        Font titleFont = new Font("Monocraft", Font.PLAIN, 80);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(titleFont);
        return titleLabel;
    }

    public JPanel titleStartButton() {
        JPanel startButtonPanel = new JPanel();
        JButton startButton = new JButton("START");

        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(new Color(0,0,0, 0));

        startButton.setBackground(new Color(0,0,0, 0));
        startButton.setForeground(Color.WHITE);
        startButton.setBorderPainted(false);
        startButton.setFocusPainted(false);
        startButton.setFont(normalFont);

        startButton.addActionListener(e -> {
            Game gamePanel = new Game();
            
            Main.window.getContentPane().removeAll();
            
            Main.window.add(gamePanel);
            
            Main.window.setLayout(null);
            gamePanel.setBounds(0, 0, 800, 600);
            
            Main.window.revalidate();
            Main.window.repaint();
            
            gamePanel.startGameThread();
        });

        startButtonPanel.add(startButton);
        return startButtonPanel;
    }

    public JPanel titleQuitButton() {
        JPanel quitButtonPanel = new JPanel();
        JButton quitButton = new JButton("QUIT");

        quitButtonPanel.setBounds(300, 490, 200, 100);
        quitButtonPanel.setBackground(new Color(0,0,0, 0));

        quitButton.setBackground(new Color(0,0,0, 0));
        quitButton.setForeground(Color.WHITE);
        quitButton.setBorderPainted(false);
        quitButton.setFocusPainted(false);
        quitButton.setFont(normalFont);

        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        quitButtonPanel.add(quitButton);

        return quitButtonPanel;
    }
}