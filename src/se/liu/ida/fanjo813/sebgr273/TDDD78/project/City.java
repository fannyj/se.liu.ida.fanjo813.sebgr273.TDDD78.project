package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-08-23.
 */
public class City {
	private boolean isStartPos;
	private Position pos;
	private BrickType brickType;

	public City(boolean isStartPos, Position pos, BrickType brickType) {
		this.isStartPos = isStartPos;
		this.pos = pos;
		this.brickType = brickType;
	}

	public boolean isStartPos() {
		return isStartPos;
	}

	public Position getPos() {
		return pos;
	}

	public BrickType getBrickType() {
		return brickType;
	}
}
