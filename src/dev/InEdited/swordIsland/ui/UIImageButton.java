package dev.InEdited.swordIsland.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] buttonImages;
    private ClickListener listener;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] buttonImages, ClickListener listener) {
        super(x, y, width, height);
        this.buttonImages = buttonImages;
        this.listener = listener;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics graphics) {
        if(!mouseHovering)
            graphics.drawImage(buttonImages[0],(int)x,(int)y,width,height,null);
        else
            graphics.drawImage(buttonImages[1],(int)x,(int)y,width,height,null);


    }

    @Override
    public void onClick() {
        listener.onClick();
    }
}
