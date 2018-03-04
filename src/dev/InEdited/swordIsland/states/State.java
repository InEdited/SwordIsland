package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.Handler;

import java.awt.*;

public abstract class State {

    public static State currentState = null;

    protected Handler handler;


    public static void setCurrentState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    //class
    public State(Handler handler){
         this.handler = handler;
    }
    public abstract void update();

    public abstract void render(Graphics graphics);


}
