package dev.InEdited.swordIsland.gfx;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.entities.Entity;

public class Camera {

    private Game game;
    private float xOffset,yOffset;

    public Camera(Game game, float xOffset, float yOffset){
        this.game = game;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void centerOnSomething(Entity entity){
        xOffset = entity.getX() - (game.getWidth() / 2) +  (entity.getWidth()/2);
        yOffset = entity.getY() - (game.getHeight() / 2) + (entity.getHeight()/2);
    }

    public void move(float xAmount, float yAmount){
        xOffset += xAmount;
        yOffset += yAmount;
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
