package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.gfx.Animation;
import dev.InEdited.swordIsland.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    //a bunch of variables that hold the stats of the player for now (to be implemented later)
    private int attack,
                armor,
                inventorySpace;

    private float attackSpeed,
                  attackRange;

    //Animations stuff
    private Animation animDown,animUp,animLeft,animRight,animAttack;


    public Player(Handler handler , float x, float y, int health) {
        super(handler,x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);

        speed = DEFAULT_SPEED;

        //collision shit of the player , refer to entity class making the bounds variable
        bounds.x =16;
        bounds.y = 22;
        bounds.height=32;
        bounds.width=32;

        //Animations
        animDown = new Animation(250,Assets.characterDown);
        animUp = new Animation(250,Assets.characterUp);
        animRight = new Animation(250,Assets.characterRight);
        animLeft = new Animation(250,Assets.characterLeft);
    }


    @Override
    public void update() {
        //Animations
        animDown.update();
        animUp.update();
        animLeft.update();
        animRight.update();

        //Movement
        getInput();
        move();
        handler.getCamera().centerOnSomething(this);
    }

    //the function that gets input from the users for the update to send the input to the move function from the creature class
    private void getInput(){
        //reset the movement every frame if the player isnt pressing any button
        moveX=0;
        moveY=0;

        //movement booiiiiii , i need to add fire button at some point Im deep into the game without fire mechanics im gonna regret this
        if(handler.getKeyManager().up)
            moveY-=speed;
        if(handler.getKeyManager().down)
            moveY+=speed;
        if(handler.getKeyManager().left)
            moveX-=speed;
        if(handler.getKeyManager().right)
            moveX+=speed;
    }

    @Override
    public void render(Graphics graphics) {
        //rendering the player and putting offset for the camera to follow the player
        graphics.drawImage(getCurrentFrame(),(int)(x - handler.getCamera().getxOffset()) ,
                                        (int)(y - handler.getCamera().getyOffset()) , width, height,null);
        //graphics.drawImage(ImageLoader.loadImage("/textures/eth.png"), (int)50, (int)50,null);


    }

    //method used in the render method to get the current frame to render , added an idle animation that is basically just the character
    private BufferedImage getCurrentFrame(){
        if(moveX<0)//moving left
            return animLeft.getCurrentFrame();
        else if(moveX>0)//moving right
            return animRight.getCurrentFrame();
        else if(moveY>0)//moving down
            return animDown.getCurrentFrame();
        else if(moveY<0)//moving up
            return animUp.getCurrentFrame();
        else
            return Assets.characterDown[0];
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
