package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-04-06.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Move{
    private int steps;
    private Player player;
    private Point pos;
    private List<Brick> brickList;

    public Move(Player player, List<Brick> brickList){
        this.player = player;
        this.steps = player.diceThrow();
        this.brickList = brickList;
        pos = player.getCurPos();
    }

    public void moveRotation(){
        /**Allows the player to move in a direction.*
         * Can max move "steps" steps
         */
        while(steps < 0){
            if(onBrick(pos)){
                /*ask player if want to flip brick*/
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to flip the marker you're\n" +
                "currently on?", "Flip brick?", JOptionPane.YES_NO_OPTION);

                if(ans == JOptionPane.YES_OPTION){
                    flipMethod();
                }
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
        if(onBrick(pos)){
            int ans = JOptionPane.showConfirmDialog(null, "Do you want to flip the marker you're\n" +
                            "currently on?", "Flip brick?", JOptionPane.YES_NO_OPTION);
            if (ans == JOptionPane.YES_OPTION){
                flipMethod();
            }
            /*ask if player want to flip brick*/
            /*if yes, ask for way*/
            /*else endTurn*/
        }
    }

    private void flipBrick(){
        /*change so that getBrick gets a pos, for nicer code*/
        Brick brick = getBrick(pos);
        switch (brick.getBrickType()){
            case MONEY:
                break;
            case SSD:
                player.canWin();
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

    private void flipMethod(){
        Object[] options = {
                "Pay for it",
                "Roll for it"
        };
        int ans = JOptionPane.showOptionDialog(null,
                "How do you want to flip the marker?",
                "Way of flipping",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if(ans == JOptionPane.YES_OPTION){
            player.removeMoney(1000);
            System.out.println("you payed");
            //flipBrick();
        }else{
            int roll = player.diceThrow();
            if(roll > 3){
                System.out.println("win");
                //flipBrick();
            }else{
                JOptionPane.showMessageDialog(null, "Didn't roll high enough.");
            }
        }
    }

    public boolean onBrick(Point pos){
        for(Brick brick : brickList){
            if(brick.getBoardPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    public Brick getBrick(Point pos){
        for (Brick brick : brickList) {
            if(brick.getBoardPosition().equals(pos)){
                return brick;
            }
        }
        return null;
    }
}
