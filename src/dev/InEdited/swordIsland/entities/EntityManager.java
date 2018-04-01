package dev.InEdited.swordIsland.entities;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.entities.creatures.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private Player player;
    private ArrayList<Entity> entities;

    //comparing y coordinates in entities to see which to render above which
    private Comparator<Entity> renderSorting = new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            if(o1.getY() + o1.getHeight() < o2.getY() + o1.getWidth())
                return -1;
            return 1;
        }
    };

    public EntityManager(Handler handler, Player player){
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);
    }

    public void update(){
        for(int i=0; i< entities.size();i++) {
            Entity e = entities.get(i);
            e.update();
            if(!e.isAlive())
                entities.remove(e);
        }
        entities.sort(renderSorting);
    }

    public void render(Graphics graphics){
        for(Entity e : entities){
            e.render(graphics);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    //getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
