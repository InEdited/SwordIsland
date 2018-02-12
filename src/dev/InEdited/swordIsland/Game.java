package dev.InEdited.swordIsland;

import display.Display;
import gfx.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private BufferedImage testImage;

    private boolean gameRunning = false;
    public int width,height;
    public String title;

    public Game(String title,int width,int height){
        this.height = height;
        this.width = width;
        this.title = title;

    }

    //Initialization
    private void init(){
        display = new Display(title,width,height);
    }

    //The game loop itself
    public void run(){
        init();

        //the fps stuff
        int fps = 60; //PC MASTER RACE
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks =0;
        while(gameRunning){
            //more fps stuff
            now = System.nanoTime();
            delta += (now-lastTime)/timePerTick;
            timer += now-lastTime;
            lastTime = now;
            
            //calling the render and update methods
            if(delta>1) {
                update();
                render();
                delta--;
                ticks++;
            }
            
            //fps tracker
            if(timer >= 1000000000){
                System.out.println("FPS = " + ticks);
                ticks = 0;
                timer = 0;
            }

        }
        stop();
    }

    private void update(){}
    //where stuff is drawn to the screen
    private void render(){
        bufferStrategy = display.getCanvas().getBufferStrategy();
        if(bufferStrategy == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();
        //Clear screen before drawing
        graphics.clearRect(0,0,width,height);
        //Start drawing shit here
        //Stop drawing shit here
        bufferStrategy.show();
        graphics.dispose();
    }


    //what happens when the thread starts
    public synchronized void start(){
        if(gameRunning)
            return;
        else
            gameRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    //What happens when the thread stops
    public synchronized  void stop(){
        if(gameRunning)
            gameRunning=false;
        else
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
