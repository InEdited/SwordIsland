package dev.InEdited.swordIsland.gfx;

import java.awt.image.BufferedImage;


public class Assets {
    public static BufferedImage image;
    private static int x,y;
    private static final int width = 48, height = 48;
    private static SpriteSheet sheet;

    public static void init(){
        //insert the path of the sprite sheet
        sheet = new SpriteSheet(ImageLoader.loadImage("/spritesheets/character1.png"));
        image = sheet.crop(0,0,width,height);
    }
}
