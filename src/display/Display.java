package display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private JFrame window;
    private Canvas canvas;

    private String title;
    private int width,height;


    public Display(String title, int i, int i1){
        width = i;
        height = i1;
        this.title = title;
        createDisplay();
    }

    private void createDisplay(){
        //creating the window
        window = new JFrame(title);
        window.setSize(width,height);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //creating canvas to draw shit on it
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));

        //putting the canvas in the window and set it up
        window.add(canvas);
        window.pack();


    }

    public Canvas getCanvas(){
        return canvas;
    }

}
