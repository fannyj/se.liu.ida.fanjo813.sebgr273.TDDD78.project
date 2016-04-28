package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Money extends Brick{
    private int amount;
	private MoneyType moneyType;

    public Money(int amount, BoardPosition position, BrickType brickType, MoneyType moneyType){
	    super(position, brickType);
        this.amount = amount;
	    this.moneyType = moneyType;
    }

	public int getAmount(){
		return amount;
	}

	public MoneyType getMoneyType(){
		return moneyType;
	}
}
