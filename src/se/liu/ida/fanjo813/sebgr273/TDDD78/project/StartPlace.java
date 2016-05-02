package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import static se.liu.ida.fanjo813.sebgr273.TDDD78.project.BrickType.EMPTY;

/**
 * Not used yet, but when the player will be restricted to only
 * starting in one of the two startplaces this will help with that
 */
public enum StartPlace {
    /*Change names to more appropriate*/
    KAIRO(new Position(13, 300, 200, EMPTY, false,"Kairo", true)), TANGER(new Position(9, 300, 100, EMPTY, false, "Tanger", true));

    public final Position position;

    StartPlace(final Position position){
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
