package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class Brick {
    private BoardPosition boardPosition;
    private BrickType brickType;

    public Brick(BoardPosition boardPosition, BrickType brickType) {
        this.boardPosition = boardPosition;
        this.brickType = brickType;
    }

    public BoardPosition getBoardPosition() {
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
