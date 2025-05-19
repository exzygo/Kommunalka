package main;

import javax.swing.*;
import java.awt.Color;
import java.awt.Container;

public class Main {
    public static JFrame window;

    public static void main(String[] args) {
        // Execute a GUI na Event Dispatch Thread
        System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("awt.useSystemAAFontSettings", "on");

        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        Container container;
        window = new JFrame();

        // WINDOW SETTINGS + WINDOW CONTAINER
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("KOMMUNALKA");
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setUndecorated(false); // Garante que as decorações da janela sejam exibidas
        window.getContentPane().setBackground(Color.BLACK);
        container = window.getContentPane();

        BackgroundPanel backgroundPanel = new BackgroundPanel("/backgrounds/menu1.png"); // ou .png
        backgroundPanel.setBounds(0, 0, 800, 600);
        window.setContentPane(backgroundPanel);

        // TITLE PANEL
        Panel titlePanelConstructor = new Panel();
        JPanel titlePanel = titlePanelConstructor.titlePanel();
        JPanel startButton = titlePanelConstructor.titleStartButton();
        JPanel quitButton = titlePanelConstructor.titleQuitButton();

        titlePanel.add(titlePanelConstructor.titleLabel());

        backgroundPanel.add(titlePanel);
        backgroundPanel.add(startButton);
        backgroundPanel.add(quitButton);

        window.toFront();
        window.setVisible(true);
    }
}