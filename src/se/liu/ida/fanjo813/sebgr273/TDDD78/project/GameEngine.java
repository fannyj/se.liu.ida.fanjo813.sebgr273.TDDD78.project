package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;

import java.util.*;
import java.util.List;

public class GameEngine extends Bank {
    private List<Player> players;
    private Player curPlayer;
    private int curPlayerIndex;
    private GameBoard board;
    private boolean winningPlayer;

    public GameEngine(int amount) {
        super(amount);
        board = new GameBoard();
	players = new ArrayList<Player>();

    }

    public void play(){
 	winningPlayer = false;
	setPlayers();
 	startGame();

//	 while(!winningPlayer){
//	     standardRotation();
//	 }
	 /*ska vara kod emellan*/
	 /*
	 if(curPlayer.onBrick() == BrickType.SSD || curPlayer.onBrick() == BrickType.STACK){
	     onWinningPiece(curPlayer);
	 }*/
    }

    public List<Position> testPossoibleMoves(Position startPos){
	int steps = 5;
	return board.possibleMoves(startPos, steps);
    }

    public void setPlayers(){
	for (int i = 0; i < 4; i++){
	    String name = "";
	    Position pos = board.getPosition(0);
	    Color color = Color.BLACK;
	    switch (i){
		case 0:
		    name = "Gert";
		    pos = board.getPosition(1);
		    color = Color.RED;
		    break;
		case 1:
		    name = "Sebastian";
		    pos = board.getPosition(5);
		    color = Color.BLUE;
		    break;
		case 2:
		    name = "Fanny";
		    pos = board.getPosition(14);
		    color = Color.MAGENTA;
		    break;
		case 3:
		    name = "Bert";
		    pos = board.getPosition(7);
		    color = Color.LIGHT_GRAY;
		    break;
	    }
	    Player player = new Player(name, pos, color);
	    players.add(player);
	}
    }

    private void standardRotation(){
        int moves = diceThrow();
        Move move = new Move(moves, curPlayer, board.getBrickList());
        move.move();

        endTurn();
    }

    private void startGame(){
        curPlayerIndex = 0;
        curPlayer = players.get(curPlayerIndex);
    }

    private void onWinningPiece(Player player){
        player.setWin();
    }

    private int diceThrow(){
        return (int) (6.0 * Math.random()) + 1;
    }

    public GameBoard getBoard(){
	return board;
    }

    public List<Player> getPlayers(){
	return players;
    }

    private void endTurn() {
        if (curPlayerIndex < players.size()) {
            curPlayerIndex++;
        } else {
            curPlayerIndex = 0;
        }
    }

}
