package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.BrickType.*;

public class GameBoard {
    private List<Position> positions;
    private List<Player> players;
    private List<Path> paths;

    public GameBoard(){
        positions = new ArrayList<Position>();
		paths = new ArrayList<Path>();
        players = new ArrayList<Player>();
        setupBoard();
    }

    public void setupBoard(){
        addPosition(1, 101, 100, SSD, true, "Linköping", false);
        addPosition(2, 200, 100, STACK, true, "Malmö", false);
        addPosition(3, 300, 100, EMPTY, false, "", false);
        addPosition(4, 450, 300, EMPTY, false, "", false);
        addPosition(98, 700, 300, EMPTY, false, "Kairo", true);
        addPosition(99, 700, 150, EMPTY, false, "Tanger", true);


        addPath(1, 2, PathType.WALK, 0, 0, 0);
        addPath(2, 3, PathType.BOAT, 300, 0, 6);
        addPath(3, 4, PathType.AIRPLANE, 1000, 0, 0);
        addPath(4, 1, PathType.WALK, 0, 0, 0);
        addPath(99, 3, PathType.WALK, 0, 0, 0);
        addPath(98, 4, PathType.WALK, 0, 0, 0);

    }

    private void addPosition(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName, boolean isStartPos){
    	Position position = new Position(id, xPos, yPos, brick, isCity, cityName, isStartPos);
    	positions.add(position);
    }

    private void addPath(int id1, int id2, PathType pathType, int costFrom1To2, int costFrom2To1, int alternativeCost){
        Path path = new Path(getPosition(id1), getPosition(id2), pathType, costFrom1To2, costFrom2To1, alternativeCost);
        paths.add(path);
    }

    public Position getPosition(int id) {
        Position position = null;
        for (Position pos : positions) {
            if (pos.getId() == id) {
                position = pos;
            }
        }
	return position;
    }

    public List<Position> getPositions() {
	return positions;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public boolean onBrick(Point point){
        /*fill with code*/
        return false;
    }

    public void getBrick(Point point){/*fill with code*/}
    /*
    public static BrickType brickAt(int posX, int posY){
        return brickList.get(0);
    }
    */
}
