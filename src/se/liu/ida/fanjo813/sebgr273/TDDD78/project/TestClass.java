package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class TestClass {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine(10000);
        Player playah = new Player("Gert");
        System.out.println(playah.toString());
        BoardViewer board = new BoardViewer();
    }
}