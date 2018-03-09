package dev.InEdited.swordIsland.maps;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.Utils.Utils;
import dev.InEdited.swordIsland.entities.EntityManager;
import dev.InEdited.swordIsland.entities.creatures.Player;
import dev.InEdited.swordIsland.entities.statics.Tree;
import dev.InEdited.swordIsland.tiles.Tile;

import java.awt.*;

public class Map{

    private Handler handler;
    private int width, height;
    //multidimensional array acts as cartesian plane (x,y) stores only IDs of the tile , w el getTile function tro7 tgeb el Tile object nfsaha
    private int[][] tiles;
    private int spawnPositionX, spawnPositionY;

    //Entities
    private EntityManager entitymanager;

    public Map(Handler handler, String path){
        this.handler = handler;
        /*
        =======================================
                    Entities
        =======================================
         */
        entitymanager = new EntityManager(handler,new Player(handler,100,100,100));
        entitymanager.addEntity(new Tree(handler,128,256));
        entitymanager.addEntity(new Tree(handler,256,256));
        entitymanager.addEntity(new Tree(handler,128,512));
        entitymanager.addEntity(new Tree(handler,256,512));


        //Loading the map from file
        loadMap(path);

        //Player (for now till I spawn others and implement network)
        spawnPositionX = 100;
        spawnPositionY = 100;
        entitymanager.getPlayer().setX(spawnPositionX);
        entitymanager.getPlayer().setY(spawnPositionY);
    }

    public void update(){
        handler.getCamera().move(handler.getCamera().getxOffset(),handler.getCamera().getyOffset());
        entitymanager.update();

    }

    /*Don't even try to understand this part cuz at this point I don't even get it
    Just embrace the spaghetti coding <3
    This part is supposed to be the part that makes only the tiles that u are able to see rendered instead of the whole thing
    got it from a blog but it really optimized the game on my underpowered laptop so
    */
    public void render(Graphics graphics){
        int startX = (int) Math.max(0 , handler.getCamera().getxOffset() / Tile.TILEWIDTH);
        int endX = (int) Math.min(width , (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH +  1 );
        int startY = (int) Math.max(0,handler.getCamera().getyOffset() / Tile.TILEHEIGHT);
        int endY  = (int) Math.min(height , (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for(int y=startY;y<endY;y++){
            for(int x=startX;x<endX;x++){
                //if i dont multiply here by width and height the tiles will stack on eachother cuz they render according to pixel position not to tiles
                //also the offset is for the camera control
                getTile(x,y).render(graphics, (int)(x*Tile.TILEWIDTH - handler.getCamera().getxOffset()),
                                                (int)(y*Tile.TILEHEIGHT - handler.getCamera().getyOffset()));

            }
        }

        //Entities
        entitymanager.render(graphics);
    }


    public Tile getTile(int x , int y){
        if(x < 0 || y < 0 || x >= width || y>= height)
            return Tile.nothing;
        //return the tile according to the id of the tile stored at (x,y) in the multi dimensional array
        Tile tile = Tile.tiles[this.tiles[x][y]];

        //if the tile you requested is not found in the tile array return default tile (nothing here)
        if(tile == null)
            return Tile.nothing;
        return tile;
    }

    private void loadMap(String path){
        String file = Utils.loadFileAsString(path);
        String[] stuffInMap = file.split("\\s+");
        width = Utils.parseInt(stuffInMap[0]);
        height = Utils.parseInt(stuffInMap[1]);

        //now start making the map according to the size of the given map file
        tiles = new int[width][height];
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                tiles[x][y] = Utils.parseInt(stuffInMap[2+(x+y*width)]);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public EntityManager getEntitymanager() {
        return entitymanager;
    }
}
