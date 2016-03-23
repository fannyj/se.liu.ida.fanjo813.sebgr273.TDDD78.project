package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameBoard {
    private ArrayList<Position> positions;
    private ArrayList<Player> players;
    private ArrayList<Path> paths;

    public GameBoard(){
        positions = new ArrayList<Position>();
        GameEngine gameEngine = new GameEngine(Integer.MAX_VALUE, players);
    }

    public void setupBoard(){
	addPosition(1, 10, 10, BrickType.SSD, true, "Linköping");
	addPosition(2, 20, 10, BrickType.STACK, true, "Malmö");
	addPosition(3, 30, 10, BrickType.EMPTY, false, "");
	addPosition(4, 40, 30, BrickType.EMPTY, false, "");

	addPath(1, 2, PathType.WALK, 0, 0, 0);
	addPath(2, 3, PathType.BOAT, 300, 0, 6);
	addPath(3, 4, PathType.AIRPLANE, 1000, 0, 0);
	addPath(4, 1, PathType.WALK, 0, 0, 0);

    }

    private void addPosition(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName){
    	Position position = new Position(id, xPos, yPos, brick, isCity, cityName);
    	positions.add(position);
    }

    private void addPath(int id1, int id2, PathType pathType, int costFrom1To2, int costFrom2To1, int alternativeCost){
	Path path = new Path(getPosition(id1), getPosition(id2), pathType, costFrom1To2, costFrom2To1, alternativeCost);
	paths.add(path);
    }

    public Position getPosition(int id) {
	Position position = null;
	for (Position pos : positions){
	    if (pos.getId() == id){
		position = pos;
	    }
	}
	return position;
    }

    public ArrayList<Position> getPositions() {
	return positions;
    }

    public ArrayList<Path> getPaths() {
	return paths;
    }


    /*
    public static BrickType brickAt(int posX, int posY){
        return brickList.get(0);
    }
    */
}
