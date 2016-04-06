package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-04-06.
 */

import java.awt.*;

public class Move {
    int steps;
    Player player;
    Point pos;

    public Move(int steps, Player player){
        this.player = player;
        this.steps = steps;
        pos = player.getCurPos();
    }

    public void move(int steps){
            /**Allows the player to move in a direction.*
             * Can max move "steps" steps
             */
    }

    private void flipBrick(){

        /*If the player wants to flip a brick this method handles it*/
    }
}
