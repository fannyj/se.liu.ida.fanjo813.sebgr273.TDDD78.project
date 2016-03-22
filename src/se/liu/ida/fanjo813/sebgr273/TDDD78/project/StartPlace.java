package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public enum StartPlace {
    /*Change names to more appropriate*/
    KAIRO(new BoardPosition(10, 5)), TANGER(new BoardPosition(20, 5));

    public final BoardPosition position;

    StartPlace(final BoardPosition position){
        this.position = position;
    }

    public BoardPosition getPosition() {
        return position;
    }
}
