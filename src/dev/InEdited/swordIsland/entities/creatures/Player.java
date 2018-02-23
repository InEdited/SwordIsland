package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.gfx.Assets;

import java.awt.*;

public class Player extends Creature {

    //a bunch of variables that hold the stats of the player for now (to be implemented later)
    private int attack,
                armor,
                inventorySpace;

    private float attackSpeed,
                  attackRange;


    public Player(Game game , float x, float y, int health) {
        super(game,x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);
        this.game = game;
        speed = DEFAULT_SPEED;
    }




    @Override
    public void update() {
        getInput();
        move();
        game.getCamera().centerOnSomething(this);
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
        //rendering the player and putting offset for the camera to follow the player
        graphics.drawImage(Assets.char1,(int)(x - game.getCamera().getxOffset()) ,
                                        (int)(y - game.getCamera().getyOffset()) , width, height,null);
        //graphics.drawImage(ImageLoader.loadImage("/textures/eth.png"), (int)50, (int)50,null);

    }

    //getters and setters
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getInventorySpace() {
        return inventorySpace;
    }

    public void setInventorySpace(int inventorySpace) {
        this.inventorySpace = inventorySpace;
    }

    public float getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(float attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public float getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(float attackRange) {
        this.attackRange = attackRange;
    }
}
