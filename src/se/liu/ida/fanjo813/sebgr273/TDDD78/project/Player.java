package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import sun.java2d.loops.GraphicsPrimitiveMgr;

import java.awt.Point;

public class Player extends Bank {
    private String playerName;
    private boolean canWin = false;
    private Position curPos;
    private Color color;

    public Player(String name, Position position, Color color) {
        super(4998);
        playerName = name;
        curPos = position;
	this.color = color;
    }


    public Color getColor() {
	return color;
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
                curPos.getX() + ":" + curPos.getY();
    }
}
