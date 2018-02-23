package dev.InEdited.swordIsland;

import dev.InEdited.swordIsland.display.Display;
import dev.InEdited.swordIsland.gfx.Assets;
import dev.InEdited.swordIsland.gfx.Camera;
import dev.InEdited.swordIsland.gfx.ImageLoader;
import dev.InEdited.swordIsland.input.KeyManager;
import dev.InEdited.swordIsland.states.GameState;
import dev.InEdited.swordIsland.states.MenuState;
import dev.InEdited.swordIsland.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private BufferedImage testImage;

    //input stuff
    private KeyManager keyManager;

    //camera stuff
    private Camera camera;

    //states
    private State gameState;
    private State menuState;


    private boolean gameRunning = false;
    private int width,height;
    public String title;

    public Game(String title,int width,int height){
        this.height = height;
        this.width = width;
        this.title = title;
        //input thing
        keyManager = new KeyManager();

    }
    //Initialization
    private void init(){
        //Assets class crops shit and gets it done
        Assets.init();
        //initiializing camera
        camera = new Camera(this,0,0);

        //initializing display
        display = new Display(title,width,height);
        display.getWindow()
                .addKeyListener(keyManager);

        //initializing the states
        gameState = new GameState(this);
        menuState = new MenuState(this);
        State.setCurrentState(gameState);
    }

    private void update(){
        //keymanager input update
        keyManager.update();
        //making sure the current state updates
        if(State.getCurrentState() !=null)
            State.getCurrentState().update();
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

        //making sure the current state always renders and pass a graphics object
        if(State.getCurrentState() !=null)
            State.getCurrentState().render(graphics);

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

    //keymanager getter for the player
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public Camera getCamera() {
        return camera;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
