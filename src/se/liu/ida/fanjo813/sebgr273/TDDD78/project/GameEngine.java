package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.swing.*;
import java.util.*;
import java.awt.Point;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.StartPlace.KAIRO;
import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.StartPlace.TANGER;

public class GameEngine extends Bank {
    private List<Player> players;
    private Player curPlayer;
    private int curPlayerIndex;
    private GameBoard board;
    private boolean winCondition;
    private Collection<BoardListener> boardListeners = new ArrayList();

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

    public void setPlayers(){
        //Player player = new Player("Gert", board.getPosition(1));
        String amount = JOptionPane.showInputDialog(null, "How many players?");
	if(amount == null){
	    System.out.println("Pressed exit");
	    System.exit(0);
	}
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
        /*curPlayer = players.get(curPlayerIn);
        Move move = new Move(curPlayer, boardtBrickList());
        move.moveRotation();
        System.out.println("Start");
        endTurn();*/
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

    public void tick(){

	for (Position position : board.getPositions()) {
	    if(position.getPos().equals(mouseClick)){
		curPlayer.setCurPos(position);
	    }
	}
	notifyListeners();
    }

    public void addListener(BoardListener b1){
	boardListeners.add(b1);
    }

    private void notifyListeners(){
	for(BoardListener boardListener : boardListeners){
	    boardListener.boardChanged();
	}
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
