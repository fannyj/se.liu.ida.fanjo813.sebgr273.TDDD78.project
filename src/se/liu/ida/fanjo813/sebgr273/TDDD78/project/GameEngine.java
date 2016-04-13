package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameEngine extends Bank {
    private List<Player> playerList;
    private Player curPlayer;
    private int curPlayerIndex;
    private GameBoard board;
    private boolean winningPlayer;

    public GameEngine(int amount, List<Player> players) {
        super(amount);
        board = new GameBoard();
        playerList = players;
        winningPlayer = false;

        startGame();

        while(!winningPlayer){
            standardRotation();
        }
        /*ska vara kod emellan*/
        /*
        if(curPlayer.onBrick() == BrickType.SSD || curPlayer.onBrick() == BrickType.STACK){
            onWinningPiece(curPlayer);
        }*/
    }

    private void standardRotation(){
        Move move = new Move(curPlayer, board.getBrickList());
        move.move();

        endTurn();
    }

    private void startGame(){
        curPlayerIndex = 0;
        curPlayer = playerList.get(curPlayerIndex);
    }

    private void onWinningPiece(Player player){
        player.setWin();
    }

    private void endTurn() {
        if (curPlayerIndex < playerList.size()) {
            curPlayerIndex++;
        } else {
            curPlayerIndex = 0;
        }
    }

}
