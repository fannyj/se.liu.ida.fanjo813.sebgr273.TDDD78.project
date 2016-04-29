package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.ArrayList;
import java.util.List;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.BrickType.*;

/**
 * Helps GameEngine with the setup of the board*
 */
public class GameBoard {
    private List<Position> positions;
    private List<Path> paths;
    private List<Brick> brickList;

    public GameBoard(){
	    positions = new ArrayList<>();
	    paths = new ArrayList<>();
	    brickList = new ArrayList<>();
	    setupBoard();
    }


    public void setupBoard(){
	    addPosition(1, 100, 100, SSD, true, "Linköping", false);
	    addPosition(2, 125, 100, EMPTY, false, "", false);
	    addPosition(3, 150, 100, MONEY, false, "", false);
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
    }

    private void addPosition(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName, boolean isStartPos){
	    Position position = new Position(id, xPos, yPos, brick, isCity, cityName, isStartPos);
	    positions.add(position);
	    addBrick(brick, position);
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

	private void addBrick(BrickType brickType, Position position){
		if (brickType.equals(MONEY)){
			MoneyType moneyType = MoneyType.getRandom();
			Brick brick = new Brick(position.getPos(), brickType);
			brick.setMoney(new Money(moneyType.amount, moneyType));
			brickList.add(brick);
		}
		if(!brickType.equals(EMPTY)){
			brickList.add(new Brick(position.getPos(), brickType));
		}
	}

    public Iterable<Position> getPositions() {
	    return positions;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public List<Brick> getBrickList() {return brickList;}

}