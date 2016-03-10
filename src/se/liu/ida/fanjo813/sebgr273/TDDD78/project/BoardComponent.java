package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import javax.swing.*;

public class BoardComponent extends JComponent {
    private Image image;

    public BoardComponent(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}