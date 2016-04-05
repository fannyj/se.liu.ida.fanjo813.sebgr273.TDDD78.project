package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.BrickType.EMPTY;

public enum StartPlace {
    /*Change names to more appropriate*/
    KAIRO(new Position(0, 10, 5, EMPTY, "Kairo")), TANGER(new Position(1, 20, 5, EMPTY, "Tanger"));

    public final Position position;

    StartPlace(final Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
