package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.swing.*;
import java.awt.*;

import java.util.*;
import java.awt.Point;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.StartPlace.KAIRO;
import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.StartPlace.TANGER;
import java.util.List;

public class GameEngine extends Bank {
    private List<Player> players;
    private Player curPlayer;
    private int curPlayerIndex;
    private GameBoard board;
    private boolean winCondition;

    public GameEngine(int amount) {
        super(amount);
        board = new GameBoard();
        players = new ArrayList<Player>();
        winCondition = false;
    }

    public void play(){

        setPlayers();
        startGame();

        while(!winCondition){
            standardRotation();
        }

        System.out.println("Someone won");
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
        //Player player = new Player("Gert", board.getPosition(1));
        String amount = JOptionPane.showInputDialog(null, "How many players?");
        int amnt = Integer.parseInt(amount);
        for(int i = 0; i < amnt; i++){
            String name = JOptionPane.showInputDialog(null, "Write the name of player " + (i+1) + ":");
            String id = JOptionPane.showInputDialog(null, "What city do you want to start in?");
            int pos = Integer.parseInt(id);
            players.add(new Player(name, board.getPosition(pos)));

        }
    }

    public void checkClickPos(Point point){

    }

    private void standardRotation(){
        curPlayer = players.get(curPlayerIndex);
        Move move = new Move(curPlayer, board.getBrickList());
        move.moveRotation();
        System.out.println("Start");
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

    public Player getCurPlayer(){
        return curPlayer;
    }

    private void endTurn() {
        System.out.println("Slut");
        if(curPlayer.getPlayerName().equals("Alex")){
            this.winCondition = true;
        } else {
            this.curPlayerIndex++;
        }
    }


}
