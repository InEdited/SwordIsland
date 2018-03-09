package dev.InEdited.swordIsland.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected  float x,y;
    protected  int width,height;
    protected  boolean mouseHovering = false;
    protected Rectangle bounds;


    public UIObject(float x , float y, int width, int height){
        this.x =x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x,(int)y,width,height);
    }

    public void onMouseMove(MouseEvent e){
        mouseHovering = bounds.contains(e.getX(), e.getY());
    }

    public void onMouseRelease(MouseEvent e ){
        if(mouseHovering&&e.getButton()==MouseEvent.BUTTON1)
            onClick();
    }

    //Abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics);
    public abstract void onClick();



    //Getters and setter
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isMouseHovering() {
        return mouseHovering;
    }

    public void setMouseHovering(boolean mouseHovering) {
        this.mouseHovering = mouseHovering;
    }
}
