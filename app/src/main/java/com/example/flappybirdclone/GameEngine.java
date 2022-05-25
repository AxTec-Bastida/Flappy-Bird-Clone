package com.example.flappybirdclone;

import android.graphics.Canvas;

public class GameEngine {

    BackgroundImage backgroundImage;

    public GameEngine(){

        backgroundImage = new BackgroundImage();

    }

    public  void updateAndDrawableBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() <- AppConstant.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstant.getBitmapBank().getBackground(), backgroundImage.getX(),backgroundImage.getY()null);
    }

}
