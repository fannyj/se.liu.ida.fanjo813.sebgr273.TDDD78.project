package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-04-06.
 */

import java.awt.*;
import java.util.List;

public class Move{
    private int steps;
    private Player player;
    private Point pos;
    private List<Brick> brickList;

    public Move(int steps, Player player, List<Brick> brickList){
        this.player = player;
        this.steps = steps;
        this.brickList = brickList;
        pos = player.getCurPos();
    }

    public void move(){
        /**Allows the player to move in a direction.*
         * Can max move "steps" steps
         */
        while(steps < 0){
            if(onBrick()){
                /*ask player if want to flip brick*/
            }else{
                //listen for player click
                /*if player clicks on point, check if viable move*/
                /*if viable move, check if special move*/
                /*if special move, ask player for payment, if no, don't move*/
                /*else steps -= 1, and go to beggining of loop*/
                //move internals to external method??
            }
        }
        /*when steps == 0*/
        if(onBrick()){
            /*ask if player want to flip brick*/
            /*if yes, ask for way*/
            /*else endTurn*/
        }
    }

    private void flipBrick(){
        /*change so that getBrick gets a pos, for nicer code*/
        Brick brick = getBrick();
        switch (brick.getBrickType()){
            case MONEY:
                /*check for exact amount*/
                break;
            case SSD:
                /*set winningPlayer to true*/
                break;
            case STACK:
                /*curPlayer.setWin, but not winningPlayer*/
                break;
            case BANDIT:
                player.bandit();
                break;
            case BLANC:
                break;
            default:
                break;
        }
        /*If the player wants to flip a brick this method handles it*/
    }

    public boolean onBrick(){
        for(Brick brick : brickList){
            if(brick.getBoardPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    public Brick getBrick(){
        for (Brick brick : brickList) {
            if(brick.getBoardPosition().equals(pos)){
                return brick;
            }
        }
        return null;
    }
}
