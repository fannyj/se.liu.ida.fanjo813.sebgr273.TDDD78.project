package TheLostDiamond;

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
