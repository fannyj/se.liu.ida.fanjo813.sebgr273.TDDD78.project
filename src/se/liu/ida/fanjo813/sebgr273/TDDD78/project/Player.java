package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.Point;

/**
 * Class for  the player in the game
 * Handles the positioning and dicethrow for the player
 * Also extends Bank for easier handling of money
 */
public class Player extends Bank {
    public static final int AMOUNT = 5000;
    private String playerName;
    private boolean canWin = false;
    private Position curPos;

    public Player(String name, Position position) {
        super(AMOUNT);
        playerName = name;
        curPos = position;
    }

    public boolean canWin(){
        return canWin;
    }

    public void setWin(){
        canWin = true;
    }

    public Point getCurPoint() {
        return curPos.getPos();
    }

    public Position getCurPos(){
	    return curPos;
    }

    public void setCurPos(Position curPos) {
        this.curPos = curPos;
    }

    public String getPlayerName(){
        return playerName;
    }

    public int diceThrow(){
        /*6.0 is the multiplier for the random nr*/
        return (int) (6.0 * Math.random()) + 1;
    }

    @Override
    public String toString(){
        return playerName
                + " has " + getAmount()
                + " dogecoins and is at " +
                curPos.getPos().getX() + ":" + curPos.getPos().getY();
    }
}
