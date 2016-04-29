package se.liu.ida.fanjo813.sebgr273.TDDD78.project;


/**
 * toplevel class for handling money for the game-engine
 * and for the player
 */
public abstract class Bank {
    protected int amount;

    protected Bank(int amount) {
        this.amount = amount;
    }

    public void addMoney(int amount){
        this.amount += amount;
    }

    public void removeMoney(int amount){
        this.amount -= amount;
    }

    public void bandit(){amount = 0;}

    public int getAmount() {
        return amount;
    }
}
