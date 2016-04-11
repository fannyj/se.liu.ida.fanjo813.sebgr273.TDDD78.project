package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameEngine {
    private List<Player> playerList;
    private Player curPlayer;
    private int curPlayerIndex;
    private GameBoard board;
    private boolean winningPlayer;

    public GameEngine() {
        board = new GameBoard();
        winningPlayer = false;

        startGame();

    }

    private void standardRotation(){

    }

    private void startGame(){

    }

    public GameBoard getBoard(){
	return board;
    }

    private int diceThrow(){
	return (int) (6.0 * Math.random()) + 1;
    }

    private void endTurn() {

    }

}
