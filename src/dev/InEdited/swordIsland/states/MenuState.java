package dev.InEdited.swordIsland.states;

import dev.InEdited.swordIsland.Handler;
import dev.InEdited.swordIsland.Launcher;
import dev.InEdited.swordIsland.display.Display;
import dev.InEdited.swordIsland.gfx.Assets;
import dev.InEdited.swordIsland.ui.ClickListener;
import dev.InEdited.swordIsland.ui.UIImageButton;
import dev.InEdited.swordIsland.ui.UIManager;

import java.awt.*;

public class MenuState extends State {

    private UIManager uiManager;
    public MenuState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageButton(handler.getGame().getWidth()/2-(256/2),
                handler.getGame().getHeight()/2-(256/2), 256, 256, Assets.button1, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUiManager(null);
                State.setCurrentState(handler.getGame().gameState);
            }
        }));
    }

    @Override
    public void update() {
        uiManager.update();
    }

    @Override
    public void render(Graphics graphics) {
        uiManager.render(graphics);
    }
}
