package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.*;

public class BoardViewer extends JFrame{
    private GameEngine game;
    private BoardComponent boardComponent;
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    private BufferedImage image;
    private JFrame myJFrame;
    private static boolean canMove = false;

    public BoardViewer(GameBoard board){
        this.board = board;
        image = null;
        try {
            image = ImageIO.read(ClassLoader.getSystemResource("resources/images/bg.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        image = resizeImage();
        myJFrame = new JFrame("Spelet");
        DefaultClickHandler mouseClickHandler = new DefaultClickHandler();
        myJFrame.addMouseListener(mouseClickHandler);

        boardComponent = new BoardComponent(image, board);
        myJFrame.setContentPane(boardComponent);
        myJFrame.setSize(WIDTH, HEIGHT);

        System.out.println(myJFrame.getSize());

        createMenus();
        myJFrame.setVisible(true);
        myJFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void setCanMove(){
        canMove = true;
    }

    public static void setCanNotMove(){
        canMove = false;
    }

    public static boolean getMoveState(){
        return canMove;
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
								"Go to main menu?",
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
class DefaultClickHandler implements MouseListener {

    private double x, y;

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point pos = e.getPoint();
        x = pos.getX()-8;
        y = pos.getY()-54;
    }

    public Point returnClickPos(){
        return new Point((int)x, (int)y);
    }
}