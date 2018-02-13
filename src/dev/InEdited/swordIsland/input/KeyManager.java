package dev.InEdited.swordIsland.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;

    public boolean up,down,left,right,fire;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void update(){
        up =keys[KeyEvent.VK_W];
        left =keys[KeyEvent.VK_A];
        down =keys[KeyEvent.VK_S];
        right =keys[KeyEvent.VK_D];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        System.out.println("Pressed the button : " + e.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
