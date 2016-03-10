package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public abstract class MoneyHandler {
    protected int amount;

    public MoneyHandler(int amount) {
        this.amount = amount;
    }

    public void addMoney(int amount){
        this.amount += amount;
    }

    public void removeMoney(int amount){
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
