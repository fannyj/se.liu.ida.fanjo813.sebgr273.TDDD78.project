package se.liu.ida.fanjo813.sebgr273.TDDD78.project;

import java.util.ArrayList;

public class Position {
    private int xPos; //Pixel position i x-led
    private int yPos; //Pixel position i y-led
    private BrickType brick; //Bara city´s kan ha bricks. Alla andra är EMPTY
    private boolean isCity;
    private String cityName;


    public Position(final int xPos, final int yPos, final BrickType brick, final boolean isCity, final String cityName) {
	this.xPos = xPos;
	this.yPos = yPos;
	this.brick = brick;
	this.isCity = isCity;
	this.cityName = cityName;
    }
}
