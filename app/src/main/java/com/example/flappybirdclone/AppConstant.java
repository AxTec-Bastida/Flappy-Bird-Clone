package com.example.flappybirdclone;

import android.content.Context;

public class AppConstant {

    //Reference to BITMAP Objects
    static  BitmapBank bitmapBank;

    //References to GAMEENGINE Objects
    static GameEngine gameEngine;

    public static void initialization(Context context){
        bitmapBank = new BitmapBank(context.getResources());
        gameEngine = new GameEngine();
    }

    //Return BITMAPBANK Instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }
    //Return GAMEENGINE INSTANCE
    public static GameEngine getGameEngine(){
        return gameEngine
    }


}
