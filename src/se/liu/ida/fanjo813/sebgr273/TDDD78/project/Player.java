package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.Point;

public class Player extends Bank {
    private String playerName;
    private boolean canWin = false;
    private Position curPos;

    public Player(String name, Position position) {
        super(5000);
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
