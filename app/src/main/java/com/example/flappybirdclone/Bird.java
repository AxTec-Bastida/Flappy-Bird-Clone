package com.example.flappybirdclone;

public class Bird {

    private int birdX, birdY, currentFrame, velocity;
    public  static int maxFrame;

    public  Bird(){
        birdX = AppConstant.SCREEN_WIDTH/2 - AppConstant.getBitmapBank().getBirdWidth()/2;
        birdY = AppConstant.SCREEN_HEIGHT/2 - AppConstant.getBitmapBank(). getBirdHeight()/2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    //GETTER FOR VELOCITY
    public int getVelocity(){
        return velocity;
    }

    //SETTER FPR VELOCITY
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }

    //GETTER METHOD FOR CURRENT FRAME
    public int getCurrentFrame(){
        return currentFrame;
    }

    //SETTER METHOD FOR CURRENT FRAME
    public  void setCurrentFrame(int currentFrame){
        this.currentFrame = currentFrame;
    }

    //GETTER METHOD FOR X - COORDINATES OF THE BIRD
    public  int getX(){
        return  birdX;
    }

    //GETTER METHOD FOR GETTING Y - COORDINATE OF THE BIRD
    public int getY(){
        return  birdY;
    }

    //SETTER METHOD FOR SETTING X - COORDINATE
    public void setX(int birdX){
        this.birdX = birdX;
    }

    //SETTER METHOD FOR SETTING y - COORDINATES
    public void setY(int birdY){
        this.birdY = birdY;
    }
}
