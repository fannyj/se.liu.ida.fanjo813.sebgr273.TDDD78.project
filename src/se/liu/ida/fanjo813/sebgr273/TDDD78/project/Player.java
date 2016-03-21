package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Player extends Bank {
    private String playerName;
    private boolean canWin = false;

    public Player(String name) {
        super(5000);
        playerName = name;
    }

    public boolean canWin(){
        return canWin;
    }

    public void setWin(){
        canWin = true;
    }

    public BrickType onBrick(){
        return GameBoard.brickAt(posX, posY);
    }

    @Override
    public String toString(){
        return playerName
                + " has " + getAmount()
                + " dogecoins.";
    }
}
