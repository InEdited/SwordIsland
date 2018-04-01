package dev.InEdited.swordIsland;

import java.awt.*;

public class Launcher {

    public static void main(String[] args){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Game game = new Game("Sword Island",screenSize.width,screenSize.height);
        game.start();
    }
}
