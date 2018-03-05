package dev.InEdited.swordIsland.tiles;

import dev.InEdited.swordIsland.gfx.Assets;

public class DirtTile extends Tile{

    protected boolean hasHitBox = true;

    @Override
    public boolean hasHitBox(){
        return this.hasHitBox;
    }

    public DirtTile(int id) {
        super(Assets.dirtTile, id);
    }

}
