package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.entities.Entity;
import dev.InEdited.swordIsland.tiles.Tile;

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
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler,x, y,width,height);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }

    //the movement function of the creature
    public void move(){
        moveX();
        moveY();

    }

    //collisions stuff added
    /*in the methods moveX/Y the methods check if the "bounds" of the creature are coming to contact
    with another tile through the collidedWithTile method and only moving if it isnt going to collide
    >I really recommend you dont try to open these functions they are messy,but they work and they handle collision well
    */
    public void moveX(){
        if(moveX>0){//move right
            int tileX = (int) (x + moveX + bounds.x + bounds.width) / Tile.TILEWIDTH;
            if(!collidedWithTile(tileX , (int)(y+bounds.y) / Tile.TILEHEIGHT) &&
                    !collidedWithTile(tileX ,(int) ((y + bounds.y +bounds.height) /Tile.TILEHEIGHT))){
                x += moveX;
            }
            else{
                x = tileX * Tile.TILEWIDTH - bounds.x - bounds.width - 1 ; //because it didnt work pixel perfect
            }
        }
        else if(moveX <0){//moving left
            int tileX = (int) (x + moveX + bounds.x) / Tile.TILEWIDTH;
            if(!collidedWithTile(tileX , (int)(y+bounds.y) / Tile.TILEHEIGHT) &&
                    !collidedWithTile(tileX ,(int) ((y + bounds.y +bounds.height) /Tile.TILEHEIGHT))){
                x += moveX;
            }
            else{
                x = tileX * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }
    public void moveY(){
        if(moveY<0){//move up
            int tileY = (int)(y + moveY + bounds.y ) / Tile.TILEHEIGHT;
            if(!collidedWithTile((int)(x + bounds.x) /Tile.TILEWIDTH , tileY) &&
                    !collidedWithTile(((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH) ,tileY)){
                y+=moveY;
            }
            else{
                y =tileY * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }
        }
        else if(moveY>0){//move down
            int tileY = (int)(y + moveY + bounds.y + bounds.height) / Tile.TILEHEIGHT;
            if(!collidedWithTile((int)(x + bounds.x) /Tile.TILEWIDTH , tileY) &&
                    !collidedWithTile(((int)(x + bounds.x + bounds.width) / Tile.TILEWIDTH) ,tileY)){
                y+=moveY;
            }
            else{
                y =tileY * Tile.TILEHEIGHT - bounds.y - bounds.width - 1;
            }

        }
    }

    protected boolean collidedWithTile(int x , int y){
        return handler.getMap().getTile(x,y).hasHitBox();
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
