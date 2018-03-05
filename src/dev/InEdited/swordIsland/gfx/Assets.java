package dev.InEdited.swordIsland.gfx;

import java.awt.image.BufferedImage;


public class Assets {
    public static BufferedImage grassTile,dirtTile,nothing;
    public static BufferedImage[] characterDown , characterUp , characterLeft , characterRight,
            trees;
    private static int x,y;
    private static final int width = 32, height = 32;
    private static final int charWidth = 48, charHeight = 48;
    private static SpriteSheet sheetCharacter,sheetProps;

    public static void init(){
        //insert the path of the sprite sheet
        sheetCharacter = new SpriteSheet(ImageLoader.loadImage("/spritesheets/character1.png"));
        sheetProps = new SpriteSheet((ImageLoader.loadImage("/spritesheets/propsKetir.png")));
        /*
        ========================================================
                            Character Animations
        ========================================================
         */
        //Character moving down animations
        characterDown = new BufferedImage[4];
        characterDown[0] = sheetCharacter.crop(charWidth *0 , charHeight * 0  , charWidth , charHeight );
        characterDown[1] = sheetCharacter.crop(charWidth *0 , charHeight * 1  , charWidth , charHeight );
        characterDown[2] = sheetCharacter.crop(charWidth *0 , charHeight * 2  , charWidth , charHeight );
        characterDown[3] = sheetCharacter.crop(charWidth *0 , charHeight * 3  , charWidth , charHeight );

        //Character moving up animations
        characterUp = new BufferedImage[4];
        characterUp[0] = sheetCharacter.crop(charWidth *2 , charHeight * 0  , charWidth , charHeight );
        characterUp[1] = sheetCharacter.crop(charWidth *2 , charHeight * 1  , charWidth , charHeight );
        characterUp[2] = sheetCharacter.crop(charWidth *2 , charHeight * 2  , charWidth , charHeight );
        characterUp[3] = sheetCharacter.crop(charWidth *2 , charHeight * 3  , charWidth , charHeight );

        //Character moving left animations
        characterLeft = new BufferedImage[4];
        characterLeft[0] = sheetCharacter.crop(charWidth *1 , charHeight * 0  , charWidth , charHeight );
        characterLeft[1] = sheetCharacter.crop(charWidth *1 , charHeight * 1  , charWidth , charHeight );
        characterLeft[2] = sheetCharacter.crop(charWidth *1 , charHeight * 2  , charWidth , charHeight );
        characterLeft[3] = sheetCharacter.crop(charWidth *1 , charHeight * 3  , charWidth , charHeight );

        //Character moving right animations
        characterRight = new BufferedImage[4];
        characterRight[0] = sheetCharacter.crop(charWidth *3 , charHeight * 0  , charWidth , charHeight );
        characterRight[1] = sheetCharacter.crop(charWidth *3 , charHeight * 1  , charWidth , charHeight );
        characterRight[2] = sheetCharacter.crop(charWidth *3 , charHeight * 2  , charWidth , charHeight );
        characterRight[3] = sheetCharacter.crop(charWidth *3 , charHeight * 3  , charWidth , charHeight );





        //TILES
        grassTile = sheetProps.crop(height*16,width*9,width,height);
        dirtTile = sheetProps.crop(height*50,width*3,width,height);
        nothing = sheetProps.crop(0,0,width,height);

        /*
        ===================================================
                        Entities and shit
        ===================================================
         */

        trees = new BufferedImage[10];
        for(int i=0;i<8;i++) {
            trees[i] = sheetProps.crop(width*(14+i) ,height *(13), width, height);
        }
    }
}
