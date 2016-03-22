package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameBoard {
    private static List<Brick> brickList;
    private ArrayList<Player> playerList;
    private List<BoardPosition> availablePos;

    public GameBoard(){
        brickList = new ArrayList<Brick>();
        brickList.add(new Brick(new BoardPosition(0, 0), BrickType.BLANC));
        GameEngine gameEngine = new GameEngine(Integer.MAX_VALUE, playerList);
    }

    public Brick getBrick(BoardPosition boardPosition){
        for (Brick brick : brickList) {
            if(brick.getBoardPosition().equals(boardPosition)){
                return brick;
            }
        } return brickList.get(0); /*change this to a standard empty spot on the map*/
    }

    public boolean onBrick(BoardPosition boardPosition){
        for (Brick brick : brickList) {
            if(brick.getBoardPosition().equals(boardPosition)){
                return true;
            }
        }
        return false;
    }
}
