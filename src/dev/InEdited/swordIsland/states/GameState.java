package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.maps.Map;

import java.awt.*;

public class GameState extends State {

    //private Player player2;
    private Map map;

    public GameState(Handler handler){
        super(handler);
        map = new Map(handler,"./res/Maps/MainMap.map");
        handler.setMap(this.map);

    }

    @Override
    public void update() {
        map.update();
    }

    @Override
    public void render(Graphics graphics) {
        map.render(graphics);
    }
}
