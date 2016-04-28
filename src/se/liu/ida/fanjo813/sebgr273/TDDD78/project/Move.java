package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

/**
 * Created by Sebastian on 2016-04-06.
 */

import java.awt.*;
import java.util.List;

public class Move{
    private List<Brick> brickList;

    public Move(List<Brick> brickList){
        this.brickList = brickList;
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
