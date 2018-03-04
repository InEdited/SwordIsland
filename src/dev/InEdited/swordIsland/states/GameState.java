package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.entities.creatures.Player;
import dev.InEdited.swordIsland.maps.Map;
import dev.InEdited.swordIsland.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Player player;
    //private Player player2;
    private Map map;

    public GameState(Handler handler){
        super(handler);
        map = new Map(handler,"./res/Maps/MainMap.map");
        handler.setMap(this.map);
        player = new Player(handler,100, 100,10);
        //player2 = new Player(game, 200,200,10);


    }

    @Override
    public void update() {
        map.update();
        player.update();
        //player2.update();

    }

    @Override
    public void render(Graphics graphics) {
        map.render(graphics);
        player.render(graphics);
        //player2.render(graphics);
        //Tile.tiles[0].render(graphics,120,120);
    }
}
