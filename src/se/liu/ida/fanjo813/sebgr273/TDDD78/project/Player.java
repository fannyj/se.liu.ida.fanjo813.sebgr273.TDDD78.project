package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import sun.java2d.loops.GraphicsPrimitiveMgr;

import java.awt.Point;

public class Player extends Bank {
    private String playerName;
    private boolean canWin = false;
    private Point curPos;

    public Player(String name, BoardPosition position) {
        super(4998);
        playerName = name;
        curPos = position.getLocation();
    }



    public boolean canWin(){
        return canWin;
    }

    public void setWin(){
        canWin = true;
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
