package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import javax.swing.*;

public class BoardComponent extends JComponent {
    private Image image;
    private GameBoard board;
    private Player player;

    public BoardComponent(Image image, GameBoard board) {
        this.image = image;
        this.board = board;
	this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
	paintPaths(g);
	paintPositions(g);
    }


    private void paintPositions(Graphics g){
	for (Position pos : board.getPositions()){
	    int x = pos.x;
	    int y = pos.y;
	    Color color = Color.GREEN;
	    int diameter = 20;
	    if (pos.isCity()){
		diameter = 20;
		color = Color.YELLOW;
	    } else if (pos.isStartPos()) {
            	diameter = 25;
            	color = Color.pink;
	    }
	    g.setColor(color);
	    g.fillOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	}
    }

    private void paintPaths(Graphics g){
	for (Path path : board.getPaths()){
	    Position p1 = path.getPosition1();
	    Position p2 = path.getPosition2();
	    // Borde swicha på olika PathType, kanske olika färg/streck...
	    g.setColor(Color.ORANGE);
	    g.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
    }

/*
    private void paintPlayer(Graphics g){
	for (Player player : board.getPlayers()){
	    int diameter = 20;
	    int x = board.getPosition(1).x;
	    int y = board.getPosition(1).y;
	    g.setColor(Color.RED);
	    g.drawOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	}
    }
*/
    /*
    Hitta på ett sätt vi ska precentera spelaren.
     */


}