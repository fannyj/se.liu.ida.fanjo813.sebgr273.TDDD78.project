package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import javax.swing.*;

public class BoardComponent extends JComponent {
    private Image image;
    private Player player;
    private GameEngine game;

    public BoardComponent(Image image, GameEngine game) {
        this.image = image;
	this.game = game;
	this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
	Graphics2D g2 = (Graphics2D) g;
	paintPaths(g2);
	paintPositions(g2);
	paintPlayers(g2);
	paintPossibleMoves(g2);
    }


    private void paintPositions(Graphics2D g2){
	for (Position pos : game.getBoard().getPositions()){
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
	    g2.setColor(color);
	    g2.fillOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	}
    }

    private void paintPaths(Graphics2D g2){
	for (Path path : game.getBoard().getPaths()){
	    Position p1 = path.getPosition1();
	    Position p2 = path.getPosition2();
	    // Borde swicha på olika PathType, kanske olika färg/streck...
	    g2.setStroke(new BasicStroke(3));
	    g2.setColor(Color.ORANGE);
	    g2.drawLine(p1.x, p1.y, p2.x, p2.y);
	}
    }


    private void paintPlayers(Graphics2D g2){
	for (Player player : game.getPlayers()){
	    int diameter = 22;
	    int x = player.getPosition().x;
	    int y = player.getPosition().y;
	    g2.setColor(player.getColor());
	    g2.setStroke(new BasicStroke(4));
	    g2.drawString("Hej där!", 800, 500);
	    g2.drawOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	}
    }

    private void paintPossibleMoves(Graphics2D g2){ //För att testa possibleMoves
	for (Position position : game.testPossoibleMoves(game.getPlayers().get(1).getPosition())){
	    int diameter = 30;
	    int x = position.x;
	    int y = position.y;
	    g2.setColor(Color.WHITE);
	    g2.setStroke(new BasicStroke(4));
	    g2.drawOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	}
    }

}