package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class TestClass {
    private static final GameBoard board = new GameBoard();

    public static final void main(String[] args) {
        Player playah = new Player("Gert");
        System.out.println(playah.toString());
        BoardViewer board = new BoardViewer();
    }
}