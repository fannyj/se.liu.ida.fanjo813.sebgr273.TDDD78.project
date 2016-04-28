package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Path goes between position1 and position2*
 */
public class Path {
    private Position position1;
    private Position position2;
    private PathType pathType; //Walk, boat, fly
    private int costFrom1To2;
    private int costFrom2To1;
    private int alternativeCost; //1 eller 6 på tärningen. Om du ej har pengar.

    public Path(Position position1, Position position2, PathType pathType, int costFrom1To2, int costFrom2To1, int alternativeCost) {
        this.position1 = position1;
        this.position2 = position2;
        this.pathType = pathType;
        this.costFrom1To2 = costFrom1To2;
        this.costFrom2To1 = costFrom2To1;
        this.alternativeCost = alternativeCost;
    }

    public Position getPosition1() {
	return position1;
    }

    public Position getPosition2() {
	return position2;
    }

    public Position otherPosition(Position pos){
	//Använd hasPosition innan. Om pos inte är en av pathens positions borde det bli exeption
	if (pos == position1){
	    return position2;
	}
	return position1;
    }

    public boolean hasPosition(Position pos){
	if (pos == position1 || pos == position2){
	    return true;
	}
	return false;
    }

    public PathType getPathType() {
	return pathType;
    }

    public int getCostFrom1To2() {
	return costFrom1To2;
    }

    public int getCostFrom2To1() {
	return costFrom2To1;
    }

    public int getAlternativeCost() {
	return alternativeCost;
    }
}
