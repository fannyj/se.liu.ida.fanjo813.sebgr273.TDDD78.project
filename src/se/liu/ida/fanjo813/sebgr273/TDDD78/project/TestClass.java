package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class TestClass {
    private static final GameBoard board = new GameBoard();
//    private static final GameEngine game = new GameEngine();

    public static final void main(String[] args) {
        Player playah = new Player("Gert", new BoardPosition(0, 0));
        System.out.println(playah.toString());
        BoardViewer boardViewer = new BoardViewer(board);
    }
}