package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * This handles with all the backend graphical stuff
 * and the interaction with the game-engine
 */
public class BoardComponent extends JComponent implements BoardListener{
	public static final int CITYDIAMETER = 20;
	public static final int STARTRADIUS = 25;
	public static final int PLAYERDIAMETER = 22;
	public static final int PLAYERXPOS = 800;
	public static final int AMOUNTYPOS = 115;
	public static final int STEPSYPOS = 130;

	private Image image;
    private  GameEngine game = null;
	private int x, y;

    public BoardComponent(Image image, final GameEngine game) {
        this.image = image;
	    this.game = game;
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

	    final Timer clickTimer = new Timer(400, mouseClick);
	    clickTimer.setCoalesce(true);
	    clickTimer.start();
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
		    if (pos.posIsCity()){
			    diameter = CITYDIAMETER;
			    color = Color.YELLOW;
		    } else if (pos.posIsStart()) {
			    diameter = STARTRADIUS;
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
		    switch (path.getPathType()){
			    case AIRPLANE:
				    g.setColor(Color.MAGENTA);
				    break;
			    case WALK:
				    g.setColor(Color.ORANGE);
				    break;
			    case BOAT:
				    g.setColor(Color.RED);
				    break;
			    default:
				    break;
		    }
		    g.drawLine(p1.getPos().x, p1.getPos().y, p2.getPos().x, p2.getPos().y);
	    }
    }

    private void paintPlayers(Graphics g){
	    if(!game.getPlayers().isEmpty()) {
		    for (Player player : game.getPlayers()) {
			    int diameter = PLAYERDIAMETER;
			    int x = player.getCurPoint().x;
			    int y = player.getCurPoint().y;
			    g.setColor(Color.RED);
			    g.drawOval(x - (diameter / 2), y - (diameter / 2), diameter, diameter);
			    g.setColor(Color.BLACK);
		    }
		    if(game.getCurPlayer() != null) {
			    g.drawString(game.getCurPlayer().getPlayerName(), PLAYERXPOS, 100);
			    g.drawString(String.valueOf(game.getCurPlayer().getAmount()),
					    PLAYERXPOS, AMOUNTYPOS);
			    g.drawString("Steps left: " + game.getSteps(),
					    PLAYERXPOS, STEPSYPOS);
		    }
	    }
    }

    public void boardChanged(){
	    repaint();
    }
}
