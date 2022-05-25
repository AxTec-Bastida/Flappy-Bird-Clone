package com.example.flappybirdclone;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background_game;

    public BitmapBank(Resources resources){

        background_game = BitmapFactory.decodeResource(resources, R.drawable.background_game);

    }

    //return background bitmap
    public Bitmap getBackground_game(){
        return background_game;
    }

    //return background width
    public int getBackgroundWidth(){
        return background_game.getWidth();
    }

    //return background height
    public int getBackgroundHeight(){
        return background_game.getHeight();
    }

}
