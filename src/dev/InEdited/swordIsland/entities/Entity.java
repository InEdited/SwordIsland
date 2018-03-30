package dev.InEdited.swordIsland.entities;

import dev.InEdited.swordIsland.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected int width,height;
    //collision stuff here
    //the rectangle is where the player can basically collide since we are looking at the game from bird eye camera
    //like the head wont interact with the environment at all
    protected Rectangle bounds;

    //init
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0,0,width,height);
    }

    public boolean checkIfCollidedWithEntity(float xOffset, float yOffset){
        for(Entity e : handler.getMap().getEntitymanager().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getBounds(0f,0f).intersects((getBounds(xOffset,yOffset))))
                return true;
        }
        return false;
    }

    //getters and setters
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

    public Rectangle getBounds(float xOffset,float yOffset) {
        return new Rectangle((int)(x + bounds.x + xOffset) , (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
    }

    //abstract methods
    public abstract void update();
    public abstract void render(Graphics graphics);

}
