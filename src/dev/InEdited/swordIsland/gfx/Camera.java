package dev.InEdited.swordIsland.gfx;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.entities.Entity;
import dev.InEdited.swordIsland.tiles.Tile;

public class Camera {

    private Handler handler;
    private float xOffset,yOffset;

    public Camera(Handler handler, float xOffset, float yOffset){
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    //this method resets the offset if the player has come close to an edge of the map so it doesnt show white space.
    public void chechIfWhite(){
        if(xOffset < 0 ){
            xOffset = 0;
        }
        else if(xOffset > handler.getMap().getWidth() * Tile.TILEWIDTH - handler.getWidth()){
            xOffset = handler.getMap().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }
        if(yOffset <0){
            yOffset = 0;
        }
        else if(yOffset > handler.getMap().getHeight() * Tile.TILEHEIGHT - handler.getHeight()){
            yOffset = handler.getMap().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    public void centerOnSomething(Entity entity){
        xOffset = entity.getX() - (handler.getWidth() / 2) +  (entity.getWidth()/2);
        yOffset = entity.getY() - (handler.getHeight() / 2) + (entity.getHeight()/2);
        chechIfWhite();
    }

    public void move(float xAmount, float yAmount){
        xOffset += xAmount;
        yOffset += yAmount;
        chechIfWhite();
    }

    public float getxOffset() {
        return xOffset;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public float getyOffset() {
        return yOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }
}
