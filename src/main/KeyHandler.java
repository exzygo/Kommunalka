package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean anyKeyPressed;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            System.out.println("W");
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            System.out.println("S");
            downPressed = true;
        }
        if (code == KeyEvent.VK_A) {
            System.out.println("A");
            leftPressed = true;
        }
        if (code == KeyEvent.VK_D) {
            System.out.println("D");
            rightPressed = true;
        }

        anyKeyPressed = upPressed || downPressed || leftPressed || rightPressed;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }

        anyKeyPressed = upPressed || downPressed || leftPressed || rightPressed;
    }
}
