package dev.InEdited.swordIsland;

import dev.InEdited.swordIsland.gfx.Camera;
import dev.InEdited.swordIsland.input.KeyManager;
import dev.InEdited.swordIsland.maps.Map;

//This class handles stuff and passes stuff from game/map altogether to make stuff a lil bit less messy

public class Handler {

    private Game game;
    private Map map;

    public Handler(Game game){
        this.game = game;
    }

    public Camera getCamera(){
        return game.getCamera();
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public Map getMap() {
        return map;
    }
    public void setMap(Map map) {
        this.map = map;
    }
}
