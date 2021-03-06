package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.Point;

public class Player extends Bank {
    private String playerName;
    private boolean canWin = false;
    private Point curPos;

    public Player(String name, BoardPosition position) {
        super(5000);
        playerName = name;
        curPos = position.getLocation();
    }

    public boolean canWin(){
        return canWin;
    }

    public void setWin(){
        canWin = true;
    }

    public void move(int steps){
        /**Allows the player to move in a direction.*
         * Can max move "steps" steps
         */
    }

    public Point getCurPos() {
        return curPos;
    }

    public void setCurPos(BoardPosition curPos) {
        this.curPos = curPos;
    }

    @Override
    public String toString(){
        return playerName
                + " has " + getAmount()
                + " dogecoins and is at " +
                curPos.getX() + ":" + curPos.getY();
    }
}
