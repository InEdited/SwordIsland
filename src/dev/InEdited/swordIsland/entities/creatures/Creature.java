package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.entities.Entity;

import java.awt.*;

public abstract class Creature extends Entity{

    public static final int DEFAULT_HEALTH =10;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_WIDTH = 64,
                            DEFAULT_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float moveX,moveY;


    //init and passing super x,y
    public Creature(Game game,float x, float y, int width, int height) {
        super(game,x, y,width,height);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }

    //the movement function of the creature
    public void move(){
        x += moveX;
        y += moveY;
    }


    public abstract void update();
    public abstract void render(Graphics graphics);


    //a bunch of getters and setters
    public static int getDefaultHealth() {
        return DEFAULT_HEALTH;
    }

    public static float getDefaultSpeed() {
        return DEFAULT_SPEED;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getMoveX() {
        return moveX;
    }

    public void setMoveX(float moveX) {
        this.moveX = moveX;
    }

    public float getMoveY() {
        return moveY;
    }

    public void setMoveY(float moveY) {
        this.moveY = moveY;
    }
}
