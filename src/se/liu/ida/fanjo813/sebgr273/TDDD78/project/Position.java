package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;

/**
 * Handles the positioning of foremost the bricks and cities of
 * the game.
 */
public class Position{
	public static final double STARTRADIUS = 12.5;
	private int id;
    private BrickType brick; //Bara city´s kan ha bricks. Alla andra är EMPTY
    private boolean isCity;
    private boolean isStartPos;
    private String cityName;
    private Point pos;
	
    public Position(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName, boolean isStartPos) {
        pos = new Point(xPos, yPos);
        this.id = id;
        this.brick = brick;
        this.isCity = isCity;
        this.cityName = cityName;
        this.isStartPos = isStartPos;
    }

    public boolean isRoughPosition(Point clickPos){
	    /**returns true if the mouseclick is within the circle*/
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
		    minX -= STARTRADIUS; minY -= STARTRADIUS; maxX += STARTRADIUS;
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

    public BrickType getBrick() {
	return brick;
    }

    public boolean posIsCity() {
	    return isCity;
    }

    public boolean posIsStart(){return isStartPos;}

    public Point getPos(){
		return pos;
    }

    public String getCityName() {
	    return cityName;
    }

}
