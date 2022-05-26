package com.example.flappybirdclone;

import java.util.Random;

public class Tube {

    //TUBE X = TUBE X - COORDINATE, TOPTUBEIFFSET Y = TOP TUBE BOTTOM EDGE COORDINATE

    private int tubeX, topTubeOffsetY;
    private Random random;
    private int tubeColor;

    public  Tube (int tubeX, int topTubeOffsetY){

        this.tubeX = tubeX;
        this.topTubeOffsetY = topTubeOffsetY;
        random = new Random();

    }

    public void setTubeColor(){
        tubeColor = random.nextInt(2);
    }

    public int getTubeColor(){
        return tubeColor;
    }

    public int getTopTubeOffsetY(){
        return topTubeOffsetY;
    }

    public int getTubeX(){
        return tubeX;
    }

    public int getTopTubeY(){
        return topTubeOffsetY - AppConstant.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return topTubeOffsetY + AppConstant.gapBetweenTopAndBottomTubes;
    }

    public void setTubeX(int tubeX){
        this.tubeX = tubeX;
    }

    public void setTopTubeOffsetY(int topTubeOffsetY){
        this.topTubeOffsetY = topTubeOffsetY;
    }
}
