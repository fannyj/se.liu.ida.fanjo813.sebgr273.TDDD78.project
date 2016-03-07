package TheLostDiamond;

import java.util.List;

public class Bank {
    private int money;

    public Bank(final int money) {
	this.money = money;
    }

    public void addMoney(int amount){
	money += amount;
    }

    public void removeMoney(int amount){
	money -= amount;
    }

    public int getMoney() {
	return money;
    }
}
