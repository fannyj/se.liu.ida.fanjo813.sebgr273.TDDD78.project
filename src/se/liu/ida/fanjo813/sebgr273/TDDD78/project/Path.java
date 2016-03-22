package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Path goes between position1 and position2
 */
public class Path {
    private Position position1;
    private Position position2;
    private PathType pathType; //Walk, boat, fly
    private int costFrom1To2;
    private int costFrom2To1;
    private int alternativCost; //1 eller 6 på tärningen. Om du ej har pengar.
}
