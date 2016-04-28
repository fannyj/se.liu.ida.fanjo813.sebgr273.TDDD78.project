package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public enum MoneyType {

    KAZOO(3000), WAT(4000), KAPPA(5000);

    public final int amount;

    MoneyType(final int amount){
        this.amount = amount;
    }

    public static MoneyType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
