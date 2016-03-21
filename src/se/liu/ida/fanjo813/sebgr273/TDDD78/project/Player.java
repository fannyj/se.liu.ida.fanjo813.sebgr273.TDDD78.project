package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Player extends Bank {
    private String playerName;
    private boolean ssd = false;
    private boolean stack = false;

    public Player(String name) {
        super(5000);
        playerName = name;
    }

    public boolean hasSsd(){
        return ssd;
    }

    public boolean hasStack(){
        return stack;
    }

    public void getSsd(){
        ssd = true;
    }

    public void getStack(){
        stack = true;
    }

    @Override
    public String toString(){
        return playerName
                + " has " + getAmount()
                + " dogecoins.";
    }
}
