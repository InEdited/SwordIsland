package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.gfx.Assets;
import dev.InEdited.swordIsland.gfx.ImageLoader;

import java.awt.*;

public class Player extends Creature {

    private Game game;



    public Player(Game game , float x, float y, int health) {
        super(x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
        speed = DEFAULT_SPEED;
    }


    @Override
    public void update() {
        getInput();
        move();
    }

    //the function that gets input from the users for the update to send the input to the move function from the creature class
    private void getInput(){
        //reset the movement every frame if the player isnt pressing any button
        moveX=0;
        moveY=0;
        
        //movement booiiiiii , i need to add fire button at some point Im deep into the game without fire mechanics im gonna regret this
        if(game.getKeyManager().up)
            moveY-=speed;
        if(game.getKeyManager().down)
            moveY+=speed;
        if(game.getKeyManager().left)
            moveX-=speed;
        if(game.getKeyManager().right)
            moveX+=speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Assets.image, (int)x, (int)y, width, height,null);
        //graphics.drawImage(ImageLoader.loadImage("/textures/eth.png"), (int)50, (int)50,null);

    }
}
