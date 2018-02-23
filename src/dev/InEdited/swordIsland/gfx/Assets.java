package dev.InEdited.swordIsland.gfx;

import java.awt.image.BufferedImage;


public class Assets {
    public static BufferedImage char1,grassTile,dirtTile;
    private static int x,y;
    private static final int width = 32, height = 32;
    private static SpriteSheet sheetCharacter,sheetProps;

    public static void init(){
        //insert the path of the sprite sheet
        sheetCharacter = new SpriteSheet(ImageLoader.loadImage("/spritesheets/character1.png"));
        sheetProps = new SpriteSheet((ImageLoader.loadImage("/spritesheets/propsKetir.png")));
        char1 = sheetCharacter.crop(0,0,48,48);
        grassTile = sheetProps.crop(height*16,width*9,width,height);
        dirtTile = sheetProps.crop(height*50,width*3,width,height);
    }
}
