package dev.InEdited.swordIsland.entities.statics;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.Utils.Utils;
import dev.InEdited.swordIsland.gfx.Assets;
import dev.InEdited.swordIsland.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tree extends StaticEntity {

    private BufferedImage tree;

    public Tree(Handler handler,float x , float y){
        super(handler,x,y, Tile.TILEWIDTH,Tile.TILEHEIGHT);

        //I use this method to diverse the trees , everytime this class is instantiated a random tree is given instead of the same one
        tree = Assets.trees[Utils.randInt(0,8)];

        //Bounds for collision (experimenting values)
        bounds.x =0;
        bounds.y=0;
        bounds.width=64;
        bounds.height=64;
    }



    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(this.tree, (int) (x - handler.getCamera().getxOffset())
                , (int) (y - handler.getCamera().getyOffset()), width, height, null);
    }
}
