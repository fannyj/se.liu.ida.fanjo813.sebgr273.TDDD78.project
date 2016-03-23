package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.*;

public class GameEngine extends Bank {
    private List<Player> playerList;
    private Player curPlayer;

    public GameEngine(int amount, ArrayList players) {
        super(amount);
        playerList = players;
        /*ska vara kod emellan*/

//        if(curPlayer.onBrick() == BrickType.SSD || curPlayer.onBrick() == BrickType.STACK){
//            onWinningPiece(curPlayer);
//        }
    }

    private void onWinningPiece(Player player){
        player.setWin();
    }

}
