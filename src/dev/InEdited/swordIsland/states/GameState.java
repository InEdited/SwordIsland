package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.entities.creatures.Player;

import java.awt.*;

public class GameState extends State {

    private Player player;

    public GameState(Game game){
        super(game);
        player = new Player(game,100, 100,10);
    }

    @Override
    public void update() {
        player.update();

    }

    @Override
    public void render(Graphics graphics) {
        player.render(graphics);
    }
}
