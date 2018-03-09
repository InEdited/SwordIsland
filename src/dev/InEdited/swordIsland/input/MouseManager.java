package dev.InEdited.swordIsland.input;

import dev.InEdited.swordIsland.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftButtonPressed, rightButtonPressed;
    private int mouseX,mouseY;
    private UIManager uiManager;

    public MouseManager(){

    }


    //Implementation methods
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftButtonPressed = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightButtonPressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftButtonPressed = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightButtonPressed = false;

        if(uiManager!=null)
            uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager!=null)
            uiManager.onMouseMove(e);
    }

    //Getters and Setters
    public boolean isLeftButtonPressed(){
        return leftButtonPressed;
    }

    public boolean isRightButtonPressed(){
        return rightButtonPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
}
