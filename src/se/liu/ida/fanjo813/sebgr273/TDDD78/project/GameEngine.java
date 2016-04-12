package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

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

    public void setPlayers(){
	Player player = new Player("Gert", board.getPosition(1));
	players.add(player);
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
