package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestClass {
    /*change this later to the run class of the application*/
//    private static final GameBoard board = new GameBoard();
    private static final GameEngine game = new GameEngine(5000);

    public static final void main(String[] args) {
//        Player playah = new Player("Gert", new BoardPosition(0, 0));
//        System.out.println(playah.toString());
        game.play();
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        System.out.println(game.getCurPlayer());
        BoardViewer boardViewer = new BoardViewer(game);
    }
}