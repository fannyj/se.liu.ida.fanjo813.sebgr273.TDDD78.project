package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Player extends MoneyHandler{
    private String playerName;

    public Player(String name) {
        super(5000);
        playerName = name;
    }

    @Override
    public String toString(){
        return playerName
                + " has " + getAmount()
                + " dogecoins.";
    }
}
