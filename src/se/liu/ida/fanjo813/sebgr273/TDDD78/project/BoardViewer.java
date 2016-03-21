package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.imageio.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;
import java.awt.Graphics2D;

public class BoardViewer extends JFrame{
    private BufferedImage image;
    private JFrame myJFrame;
    private int height, width;

    public BoardViewer(int width, int height){
        this.height = height;
        this.width = width;
        image = null;
        try {
            image = ImageIO.read(ClassLoader.getSystemResource("resources/images/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = resizeImage();
        myJFrame = new JFrame("Spelet");
        myJFrame.setContentPane(new BoardComponent(image));
        myJFrame.setSize(this.width, this.height);
        createMenus();
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }



    private BufferedImage resizeImage() {
        int type=0;
        type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
        BufferedImage resizedImage = new BufferedImage(WIDTH, HEIGHT,type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

    private void createMenus(){
	final JMenuBar menuBar = new JMenuBar();

	final JMenu gameMenu = new JMenu("Game");
	final JMenu optionMenu = new JMenu("Option");
	final JMenuItem newGameItem = new JMenuItem("New Game");
	final JMenuItem quitItem = new JMenuItem("Main Menu");
	final JMenuItem screenSize = new JMenuItem("Screen Size");
	final JMenuItem name = new JMenuItem("Name");
	gameMenu.add(newGameItem);
	gameMenu.addSeparator();
	gameMenu.add(quitItem);
	optionMenu.add(screenSize);
	optionMenu.add(name);

/*
	newGameItem.addActionListener(new ActionListener() {
	    @Override public void actionPerformed(final ActionEvent e) {
		Object[] options = {"Yes", "Cancel"};
		int optionChosen = JOptionPane.showOptionDialog(null,
								"New Game",
								"New Game",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,
								options,
								options[1]);
			if (optionChosen == JOptionPane.YES_OPTION){
			    startNewGame();
			}
		    }
		});

*/
	quitItem.addActionListener(new ActionListener() {
	    @Override public void actionPerformed(final ActionEvent e) {
		Object[] options = {"Yes", "Cancel"};
		int optionChosen = JOptionPane.showOptionDialog(null,
								"Are you sure?",
								"Go to main menu",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,
								options,
								options[1]);
		if (optionChosen == JOptionPane.YES_OPTION){
		    System.exit(0);
		}
	    }
	});

	menuBar.add(Box.createHorizontalGlue());
	menuBar.add(gameMenu);
	menuBar.add(optionMenu);
	myJFrame.setJMenuBar(menuBar);

    }

}
