package dev.InEdited.swordIsland.ui;

import dev.InEdited.swordIsland.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler){
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    public void update(){
        for(UIObject object : objects)
            object.update();
    }

    public void render(Graphics graphics){
        for(UIObject object : objects)
            object.render(graphics);
    }

    public void onMouseMove(MouseEvent e){
        for(UIObject object : objects)
            object.onMouseMove(e);
    }

    public void onMouseRelease(MouseEvent e){
        for(UIObject object : objects)
            object.onMouseRelease(e);
    }

    public void addObject(UIObject object){
        objects.add(object);
    }

    public void removeObject(UIObject object){
        objects.remove(object);
    }
}
