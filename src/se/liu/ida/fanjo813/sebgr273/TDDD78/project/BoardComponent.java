package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class BoardComponent extends JComponent implements BoardListener{
    private Image image;
    private Player player;
    private  GameEngine game = null;
	private int x, y;

    public BoardComponent(Image image, GameEngine game) {
        this.image = image;
	    this.game = game;
	    this.player = game.getCurPlayer();
	    //DefaultClickHandler mouseClickHandler = new DefaultClickHandler();
	    this.addMouseListener(new MouseListener() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
			    x = e.getX();
			    y = e.getY();
			    System.out.println(x + " : " + y);
		    }

		    @Override
		    public void mousePressed(MouseEvent e) {

		    }

		    @Override
		    public void mouseReleased(MouseEvent e) {

		    }

		    @Override
		    public void mouseEntered(MouseEvent e) {

		    }

		    @Override
		    public void mouseExited(MouseEvent e) {

		    }
	    });
	    Action mouseClick = new AbstractAction(){
		    public void actionPerformed(ActionEvent e){
			    game.tick(new Point(x, y));
		    }
	    };

	    final Timer clockTimer = new Timer(400, mouseClick);
	    clockTimer.setCoalesce(true);
	    clockTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
	    paintPaths(g);
	    paintPositions(g);
	    paintPlayers(g);
    }

    private void paintPositions(Graphics g){
	    for (Position pos : game.getBoard().getPositions()){
		    int x = pos.getPos().x;
		    int y = pos.getPos().y;
		    Color color = Color.GREEN;
		    int diameter = 10;
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
	    for (Path path : game.getBoard().getPaths()){
		    Position p1 = path.getPosition1();
		    Position p2 = path.getPosition2();
		    // Borde swicha på olika PathType, kanske olika färg/streck...
		    g.setColor(Color.ORANGE);
		    g.drawLine(p1.getPos().x, p1.getPos().y, p2.getPos().x, p2.getPos().y);
	    }
    }

    private void paintPlayers(Graphics g){
	    for (Player player : game.getPlayers()){
		    int diameter = 22;
		    int x = player.getCurPos().x;
		    int y = player.getCurPos().y;
		    g.setColor(Color.RED);
		    g.drawString("Hej där!", 800, 500);
		    g.drawOval(x-(diameter/2), y-(diameter/2), diameter, diameter);
	    }
    }

    public void boardChanged(){
	    repaint();
    }
}
