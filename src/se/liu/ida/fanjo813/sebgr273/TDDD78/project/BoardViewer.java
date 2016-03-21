package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.imageio.*;
import javax.swing.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class BoardViewer{
    public static void main(String[] args) {
        BufferedImage image = null;
        try {
//            image = ImageIO.read(new File("C:\\Users\\Aids\\TDDD78\\se.liu.ida.fanjo813.sebgr273.TDDD78" + "" +
//                                           ".project\\src\\resources\\images\\tomten.png"));
	    image = ImageIO.read(ClassLoader.getSystemResource("resources/images/tomten.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JFrame myJFrame = new JFrame("Spelet");
        myJFrame.setContentPane(new BoardComponent(image));
        myJFrame.setSize(800, 600);
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
