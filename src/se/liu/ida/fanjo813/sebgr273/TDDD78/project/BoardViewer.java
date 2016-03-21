package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.imageio.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.Graphics2D;

public class BoardViewer{

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private static BufferedImage image;

    public static void main(String[] args) {
        image = null;
        try {
            image = ImageIO.read(ClassLoader.getSystemResource("resources/images/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage();
        JFrame myJFrame = new JFrame("Spelet");
        myJFrame.setContentPane(new BoardComponent(image));
        myJFrame.setSize(WIDTH, HEIGHT);
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static BufferedImage resizeImage() {
        int type=0;
        type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(WIDTH, HEIGHT,type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        return resizedImage;
    }
}
