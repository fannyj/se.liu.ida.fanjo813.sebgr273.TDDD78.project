package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.Point;

public class Brick {
    private Point boardPosition;
    private BrickType brickType;

    public Brick(Point boardPosition, BrickType brickType) {
        this.boardPosition = boardPosition;
        this.brickType = brickType;
    }

    public Point getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(BoardPosition boardPosition) {
        this.boardPosition = boardPosition;
    }

    public BrickType getBrickType() {
        return brickType;
    }

    public void setBrickType(BrickType brickType) {
        this.brickType = brickType;
    }
}
