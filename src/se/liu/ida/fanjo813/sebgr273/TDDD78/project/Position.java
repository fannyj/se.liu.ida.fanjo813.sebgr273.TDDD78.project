package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.ArrayList;

public class Position {
    private int id;
    private int xPos; //Pixel position i x-led
    private int yPos; //Pixel position i y-led
    private BrickType brick; //Bara city´s kan ha bricks. Alla andra är EMPTY
    private boolean isCity;
    private String cityName;


    public Position(int id, int xPos, int yPos, BrickType brick, boolean isCity, String cityName) {
	this.id = id;
	this.xPos = xPos;
	this.yPos = yPos;
	this.brick = brick;
	this.isCity = isCity;
	this.cityName = cityName;
    }


    public int getId() {
	return id;
    }

    public int getxPos() {
	return xPos;
    }

    public int getyPos() {
	return yPos;
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
