package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Money{
    private int amount;
	private MoneyType moneyType;

    public Money(int amount, MoneyType moneyType){
        this.amount = amount;
	    this.moneyType = moneyType;
    }

	public int getAmount(){
		return amount;
	}

	public MoneyType getMoneyType(){
		return moneyType;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setMoneyType(MoneyType moneyType) {
		this.moneyType = moneyType;
	}
}
