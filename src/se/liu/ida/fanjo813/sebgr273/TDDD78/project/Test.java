package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * The run class for the game*
 */
public final class Test {
    /*change this later to the run class of the application*/
    private static final GameEngine GAME_ENGINE = new GameEngine(5000);

    private Test(){}

    public static void main(String[] args) {
        new BoardViewer(GAME_ENGINE);
        GAME_ENGINE.play();
        for (Player player : GAME_ENGINE.getPlayers()) {
            System.out.println(player);
        }
        System.out.println(GAME_ENGINE.getCurPlayer());

    }
}