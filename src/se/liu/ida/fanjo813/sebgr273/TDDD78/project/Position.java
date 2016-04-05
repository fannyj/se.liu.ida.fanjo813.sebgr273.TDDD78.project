package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.awt.*;
import java.util.ArrayList;

public class Position extends Point {
    private int id;
    private BrickType brick; //Bara city´s kan ha bricks. Alla andra är EMPTY
    private boolean isCity;
    private String cityName;


    public Position(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName) {
	super(xPos, yPos);
	this.id = id;
	this.brick = brick;
	this.isCity = isCity;
	this.cityName = cityName;
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

    public String getCityName() {
	return cityName;
    }
}
