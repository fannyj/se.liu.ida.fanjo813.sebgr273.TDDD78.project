package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameBoard {
    private static List<BrickType> brickList;
    private ArrayList<Player> playerList;

    public GameBoard(){
        brickList = new ArrayList<BrickType>();
        brickList.add(0, BrickType.BLANC);
        GameEngine gameEngine = new GameEngine(Integer.MAX_VALUE, playerList);
    }

    public static BrickType brickAt(int posX, int posY){
        return brickList.get(0);
    }
}
