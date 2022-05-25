package com.example.flappybirdclone;

public class BackgroundImage {

    private int backgroundImageX, backgroundImageY, getBackgroundVelocity;

    public BackgroundImage(){

        backgroundImageX = 0;
        backgroundImageY = 0;
        getBackgroundVelocity = 3;

    }

    //Method to obtain X-Coordinate
    public int getX(){
        return backgroundImageX;
    }

    //Method to obtain Y-Coordinates
    public int getY(){
        return backgroundImageY;
    }

    //Method for the setting of the X - Coordinate
    public void setX(int backgroundImageX){
        this.backgroundImageX = backgroundImageX;
    }

    //Method for the setting of the Y - Coordinate
    public void setY(int backgroundImageY){
        this.backgroundImageY = backgroundImageY;
    }

    //Method to obtain Velocity
    public int getVelocity(){
        return getBackgroundVelocity;
    }


}
