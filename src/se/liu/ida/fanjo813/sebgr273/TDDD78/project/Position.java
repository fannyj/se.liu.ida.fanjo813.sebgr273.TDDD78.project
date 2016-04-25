package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import java.util.ArrayList;

public class Position{
    private int id;
    private BrickType brick; //Bara city´s kan ha bricks. Alla andra är EMPTY
    private boolean isCity;
    private boolean isStartPos;
    private String cityName;
    private Point pos;


    public Position(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName, boolean isStartPos) {
        pos = new Point(xPos, yPos);
        this.id = id;
        this.brick = brick;
        this.isCity = isCity;
        this.cityName = cityName;
        this.isStartPos = isStartPos;
    }


    public int getId() {
	return id;
    }

    public BrickType getBrick() {
	return brick;
    }

    public boolean isCity() {
	return isCity;
    }

    public boolean isStartPos(){return isStartPos;}

    public Point getPos(){
	return pos;
    }

    public String getCityName() {
	return cityName;
    }
}
