package TheLostDiamond;

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
