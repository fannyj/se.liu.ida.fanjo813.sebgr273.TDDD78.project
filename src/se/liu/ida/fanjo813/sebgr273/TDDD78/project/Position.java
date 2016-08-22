package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;

/**
 * Handles the positioning of foremost the bricks and cities of
 * the game.
 */
public class Position{
	public static final double STARTRADIUS = 12.5;
	private int id;
    private Point pos;
	
    public Position(int id, int xPos, int yPos) {
        pos = new Point(xPos, yPos);
        this.id = id;
    }

	/**returns true if the mouseclick is within the circle*/
    public boolean isRoughPosition(Point clickPos){

	    double clickX = clickPos.getX();
	    double clickY = clickPos.getY();
	    double minX = pos.getX();
	    double minY = pos.getY();
	    double maxX = pos.getX();
	    double maxY = pos.getY();

	    if(this.isCity){
		    minX -= 10; minY -= 10; maxX += 10;
		    maxY += 10;
	    } else if (this.isStartPos){
		    minX -= STARTRADIUS; inY -= STARTRADIUS; maxX += STARTRADIUS;
		    maxY += STARTRADIUS;
	    } else {
		    minX -= 5; minY -= 5; maxX += 5;
		    maxY += 5;
	    }
	    if(clickX <= maxX && clickX >= minX &&
			    clickY <= maxY && clickY >= minY){
		    return true;
	    }
	    return false;
    }

    public int getId() {
	return id;
    }


}
