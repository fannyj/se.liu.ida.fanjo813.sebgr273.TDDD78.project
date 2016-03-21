package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

public class TestClass {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine(10000);
        Player playah = new Player("Gert");
        System.out.println(playah.toString());
        System.out.println(playah.hasSsd());
        System.out.println(playah.hasStack());
        //BoardViewer board = new BoardViewer();
    }
}