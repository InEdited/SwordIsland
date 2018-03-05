package dev.InEdited.swordIsland.tiles;

import dev.InEdited.swordIsland.entities.statics.Tree;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    //static shit

    public static Tile[] tiles = new Tile[256];
    public static Tile nothing = new Nothing(255);
    public static Tile grassTile = new GrassTile(0);
    public static Tile dirtTile = new DirtTile(1);


    //rest of shit

    public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
    protected BufferedImage texture;
    protected final int id;
    protected boolean hasHitBox = false;

    public Tile(BufferedImage texture,int id){
        this.id = id;
        this.texture = texture;

        tiles[id] = this;

    }

    public boolean hasHitBox(){
        return this.hasHitBox;
    }

    public void update(){

    }

    public void render(Graphics graphics,int x,int y){
        graphics.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);

    }


    public int getId() {
        return id;
    }
}
