package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.ArrayList;
import java.util.List;
import java.awt.*;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.BrickType.*;

public class GameBoard {
    private List<Position> positions;
    private List<Player> players;
    private List<Path> paths;
    private List<Brick> brickList;

    public GameBoard(){
        positions = new ArrayList<Position>();
	paths = new ArrayList<Path>();
        players = new ArrayList<Player>();
        brickList = new ArrayList<Brick>();
        setupBoard();
    }

    public List<Position> possibleMoves(Position startPos, int steps){
	List<Position> moves = new ArrayList<Position>(possibleMoves(startPos, steps, paths));
	if (startPos.isCity()){
	    moves.remove(startPos);
	}
	return moves;
    }

    private List<Position> possibleMoves(Position curPos, int steps, List<Path> remaining){
	List<Path> rest = new ArrayList<Path>(remaining);
	List<Position> moves = new ArrayList<Position>();
	if (steps == 0){ //Rekursivt basfall
	    moves.add(curPos);
	    return moves;
	}
	if (curPos.isCity()){ //Städer ska läggas till i listan och ska fortsätta gå
	    moves.add(curPos);
	}
	for (Path path : remaining){
	    if (path.hasPosition(curPos)){ //Hittade en väg att gå
		rest.remove(path);
		moves.addAll(possibleMoves(path.otherPosition(curPos), steps-1, rest));
	    }
	}

	return moves;
    }


    public void setupBoard(){
        addPosition(1, 100, 100, SSD, true, "Linköping", false);
	addPosition(2, 125, 100, EMPTY, false, "", false);
	addPosition(3, 150, 100, EMPTY, false, "", false);
	addPosition(4, 175, 100, EMPTY, false, "", false);
	addPosition(5, 200, 100, SSD, true, "Göteborg", false);
	addPosition(6, 225, 100, EMPTY, false, "", false);
	addPosition(7, 250, 100, EMPTY, false, "", false);
	addPosition(8, 275, 100, EMPTY, false, "", false);
	addPosition(9, 300, 100, EMPTY, false, "Stockholm", true);
	addPosition(10, 300, 125, EMPTY, false, "", false);
	addPosition(11, 300, 150, EMPTY, false, "", false);
	addPosition(12, 300, 175, EMPTY, false, "", false);
	addPosition(13, 300, 200, EMPTY, false, "Kiruna", true);
	addPosition(14, 275, 200, EMPTY, false, "", false);
	addPosition(15, 250, 200, EMPTY, false, "", false);
	addPosition(16, 225, 200, EMPTY, false, "", false);
	addPosition(17, 200, 200, SSD, true, "Örebro", false);
	addPosition(18, 175, 200, EMPTY, false, "", false);
	addPosition(19, 150, 200, EMPTY, false, "", false);
	addPosition(20, 125, 200, EMPTY, false, "", false);
	addPosition(21, 100, 200, SSD, true, "Edsbyn", false);
	addPosition(22, 100, 175, EMPTY, false, "", false);
	addPosition(23, 100, 150, EMPTY, false, "", false);
	addPosition(24, 100, 125, EMPTY, false, "", false);
	addPosition(25, 200, 125, EMPTY, false, "", false);
	addPosition(26, 200, 150, EMPTY, false, "", false);
	addPosition(27, 200, 175, EMPTY, false, "", false);

//        addPosition(98, 700, 300, EMPTY, false, "Kairo", true);
//        addPosition(99, 700, 150, EMPTY, false, "Tanger", true);


        addPath(1, 2, PathType.WALK, 0, 0, 0);
        addPath(2, 3, PathType.BOAT, 300, 0, 6);
        addPath(3, 4, PathType.AIRPLANE, 1000, 0, 0);
        addPath(4, 5, PathType.WALK, 0, 0, 0);
	addPath(5, 6, PathType.WALK, 0, 0, 0);
	addPath(6, 7, PathType.WALK, 0, 0, 0);
	addPath(7, 8, PathType.WALK, 0, 0, 0);
	addPath(8, 9, PathType.WALK, 0, 0, 0);
	addPath(9, 10, PathType.WALK, 0, 0, 0);
	addPath(10, 11, PathType.WALK, 0, 0, 0);
	addPath(11, 12, PathType.WALK, 0, 0, 0);
 	addPath(12, 13, PathType.BOAT, 300, 0, 6);
	addPath(13, 14, PathType.AIRPLANE, 1000, 0, 0);
	addPath(14, 15, PathType.WALK, 0, 0, 0);
	addPath(15, 16, PathType.WALK, 0, 0, 0);
	addPath(16, 17, PathType.WALK, 0, 0, 0);
	addPath(17, 18, PathType.WALK, 0, 0, 0);
	addPath(18, 19, PathType.WALK, 0, 0, 0);
	addPath(19, 20, PathType.WALK, 0, 0, 0);
	addPath(20, 21, PathType.WALK, 0, 0, 0);
	addPath(21, 22, PathType.WALK, 0, 0, 0);
	addPath(22, 23, PathType.BOAT, 300, 0, 6);
	addPath(23, 24, PathType.AIRPLANE, 1000, 0, 0);
	addPath(24, 1, PathType.AIRPLANE, 1000, 0, 0);
	addPath(5, 25, PathType.WALK, 0, 0, 0);
	addPath(25, 26, PathType.WALK, 0, 0, 0);
	addPath(26, 27, PathType.WALK, 0, 0, 0);
	addPath(27, 17, PathType.WALK, 0, 0, 0);

//        addPath(99, 3, PathType.WALK, 0, 0, 0);
//        addPath(98, 4, PathType.WALK, 0, 0, 0);

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


    public List<Brick> getBrickList() {return brickList;}
    /*
    public static BrickType brickAt(int posX, int posY){
        return brickList.get(0);
    }
    */
}
