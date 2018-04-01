package dev.InEdited.swordIsland.entities.creatures;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.entities.Entity;
import dev.InEdited.swordIsland.gfx.Animation;
import dev.InEdited.swordIsland.gfx.Assets;
import dev.InEdited.swordIsland.states.State;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.lang.Math.abs;

public class Player extends Creature {

    //a bunch of variables that hold the stats of the player for now (to be implemented later)
    private int attackDamage = 5,
                armor,
                inventorySpace,
                attackRange = 20;

    private float attackSpeed = 3;

    private long  attackTimer,
            lastAttackTimer;

    //Animations stuff
    private Animation animDown,animUp,animLeft,animRight,animAttack;


    public Player(Handler handler , float x, float y, int health) {
        super(handler,x, y, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);

        speed = 5;

        //collision shit of the player , refer to entity class making the bounds variable
        bounds.x =16;
        bounds.y = 22;
        bounds.height=32;
        bounds.width=32;

        //Animations
        animDown = new Animation((int)(750/this.speed),Assets.characterDown);
        animUp = new Animation((int)(750/this.speed),Assets.characterUp);
        animRight = new Animation((int)(750/this.speed),Assets.characterRight);
        animLeft = new Animation((int)(750/this.speed),Assets.characterLeft);
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

        //Attacking
        checkAttacks();
    }

    private void checkAttacks(){
        //timing the attack according to attack speed
        int attackCooldown = (int) (1000/attackSpeed);
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();
        if(attackTimer < attackCooldown)
            return;



        int mouseQuadrant = cursoreQuadrant();
        Rectangle playerBounds = getBounds(0,0);
        Rectangle attackRectangle = new Rectangle();
        attackRectangle.height = attackRange;
        attackRectangle.width = attackRange;

        //Attacking right
        if((mouseQuadrant==1||mouseQuadrant==8)&&handler.getMouseManager().isLeftButtonPressed()){
            attackRectangle.y = playerBounds.y - attackRange;
            attackRectangle.x = playerBounds.y + playerBounds.height / 2 - attackRange / 2;
            System.out.println("Attacked right");

        }

        //Attacking up
        else if((mouseQuadrant==6||mouseQuadrant==7)&&handler.getMouseManager().isLeftButtonPressed()){
            attackRectangle.x = playerBounds.x + playerBounds.width / 2 - attackRange / 2;
            attackRectangle.y = playerBounds.y - attackRange;
            System.out.println("Attacked up");
        }

        //Attacking left
        else if((mouseQuadrant==4||mouseQuadrant==5)&&handler.getMouseManager().isLeftButtonPressed()){
            attackRectangle.x = playerBounds.x - attackRange;
            attackRectangle.y = playerBounds.y + playerBounds.height / 2 - attackRange / 2;
            System.out.println("Attacked left");

        }

        //Attacking down
        else if((mouseQuadrant==3||mouseQuadrant==2)&&handler.getMouseManager().isLeftButtonPressed()){
            attackRectangle.x = playerBounds.x + playerBounds.width / 2 - attackRange / 2;
            attackRectangle.y = playerBounds.y + playerBounds.height;
            System.out.println("Attacked down");

        }else
            return;

        attackTimer =0;

        for(Entity entity : handler.getMap().getEntitymanager().getEntities()){
            if(entity.equals(this))
                continue;
            if(entity.getBounds(0,0).intersects(attackRectangle)){
                entity.hurt(attackDamage);
                return;
            }
        }
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
    public void die(){
        State.setCurrentState(handler.getGame().menuState);
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
        int position = cursoreQuadrant();
        //character moving and mouse is in different direction
        if((moveX!=0 || moveY!=0) && (position == 4 || position == 5))//moving left
            return animLeft.getCurrentFrame();
        else if((moveX!=0 || moveY!=0) && (position == 1 || position == 8))//moving right
            return animRight.getCurrentFrame();
        else if((moveY!=0 || moveX!=0) && (position == 2 || position == 3))//moving down
            return animDown.getCurrentFrame();
        else if((moveY!=0 || moveX!=0) && (position == 6 || position == 7))//moving up
            return animUp.getCurrentFrame();

        //Character not moving but mouse position is far from character

        //Mouse down
        else if(moveY==0&&moveX==0 && (position == 2 || position == 3))
            return Assets.characterDown[0];

        //Mouse up
        else if(moveY==0&&moveX==0 && (position == 6 || position == 7))
            return Assets.characterUp[0];

        //Mouse left
        else if(moveY==0&&moveX==0 && (position == 4 || position == 5))
            return Assets.characterLeft[0];

        //Mouse right
        else if(moveY==0&&moveX==0 && (position == 1 || position == 8))
            return Assets.characterRight[0];

        //whatever
        else
            return Assets.characterDown[0];
    }

    public int cursoreQuadrant(){
        int positionX = (int) (x - handler.getCamera().getxOffset());
        int positionY = (int) (y - handler.getCamera().getyOffset());
        int mouseX = handler.getMouseManager().getMouseX();
        int mouseY = handler.getMouseManager().getMouseY();
        int x = mouseX - positionX;
        int y = mouseY - positionY;

        if(abs(x)>abs(y) && x > 0 && y > 0)
            return 1;
        if(abs(x)<abs(y) && x > 0 && y > 0)
            return 2;
        if(abs(x)<abs(y) && x < 0 && y > 0)
            return 3;
        if(abs(x)>abs(y) && x < 0 && y > 0)
            return 4;
        if(abs(x)>abs(y) && x < 0 && y < 0)
            return 5;
        if(abs(x)<abs(y) && x < 0 && y < 0)
            return 6;
        if(abs(x)<abs(y) && x > 0  && y < 0)
            return 7;
        if(abs(x)>abs(y) && x > 0 && y < 0)
            return 8;
        return 0;


    }

    //getters and setters
    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
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

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }


}
