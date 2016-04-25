package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-04-06.
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Move{
    private Player player;
    private Point pos;
    private List<Brick> brickList;

    public Move(List<Brick> brickList){
        this.brickList = brickList;
        pos = player.getCurPos();
    }

    public boolean onBrick(Point pos){
        for(Brick brick : brickList){
            if(brick.getBoardPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    public Brick getBrick(Point pos){
        for (Brick brick : brickList) {
            if(brick.getBoardPosition().equals(pos)){
                return brick;
            }
        }
        return null;
    }
}
