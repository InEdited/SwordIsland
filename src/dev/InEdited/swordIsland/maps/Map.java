package dev.InEdited.swordIsland.maps;

import dev.InEdited.swordIsland.Game;
import dev.InEdited.swordIsland.Utils.Utils;
import dev.InEdited.swordIsland.tiles.Tile;

import java.awt.*;

public class Map{

    private Game game;
    private int width, height;
    //multidimensional array acts as cartesian plane (x,y) stores only IDs of the tile , w el getTile function tro7 tgeb el Tile object nfsaha
    private int[][] tiles;
    private int spawnPositionX, spawnPositionY;

    public Map(Game game, String path){
        this.game = game;
        loadMap(path);
    }

    public void update(){
        game.getCamera().move(game.getCamera().getxOffset(),game.getCamera().getyOffset());


    }

    public void render(Graphics graphics){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                //if i dont multiply here by width and height the tiles will stack on eachother cuz they render according to pixel position not to tiles
                //also the offset is for the camera control
                getTile(x,y).render(graphics, (int)(x*Tile.TILEWIDTH - game.getCamera().getxOffset()),
                                                (int)(y*Tile.TILEHEIGHT - game.getCamera().getyOffset()));

            }
        }
    }


    public Tile getTile(int x , int y){
        //return the tile according to the id of the tile stored at (x,y) in the multi dimensional array
        Tile tile = Tile.tiles[this.tiles[x][y]];

        //if the tile you requested is not found in the tile array return default tile (grass tilie here)
        if(tile == null)
            return Tile.grassTile;
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
}
