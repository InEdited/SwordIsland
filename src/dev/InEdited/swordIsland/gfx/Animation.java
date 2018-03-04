package dev.InEdited.swordIsland.gfx;

import java.awt.image.BufferedImage;

public class Animation {
    private int speed , index;
    private long lastTime , timer; //for the timer
    private BufferedImage[] frames;

    public Animation(int speed , BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer =0;
        lastTime = System.currentTimeMillis();
    }

    //the timer that makes the class changes the rendered frame and get another one from the assets
    public void update(){
        timer+= System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index=0;
        }
    }
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
