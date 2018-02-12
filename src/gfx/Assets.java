package gfx;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage image;
    private static int x,y,width,height;

    public static void init(){
        //insert the path of the sprite sheet
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/eth.png"));
        image = sheet.crop(x,y,width,height);
    }
}
