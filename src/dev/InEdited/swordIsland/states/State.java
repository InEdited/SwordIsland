package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Game;

import java.awt.*;

public abstract class State {

    public static State currentState = null;

    protected Game game;


    public static void setCurrentState(State state){
        currentState = state;
    }

    public static State getCurrentState() {
        return currentState;
    }

    //class
    public State(Game game){
         this.game = game;
    }
    public abstract void update();

    public abstract void render(Graphics graphics);


}
