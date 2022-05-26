package com.example.flappybirdclone;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstant {

    //Reference to BITMAP Objects
    static  BitmapBank bitmapBank;

    static  int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static  int VELOCITY_WHEN_JUMPED;
    static int gapBetweenTopAndBottomTubes;

    static int numberOfTubes;
    static  int tubeVelocity;
    static int minTubeOffsetY;
    static int maxTubeOffsetY;
    static int distanceBetweenTubes;

    //References to GAMEENGINE Objects
    static GameEngine gameEngine;

    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        setFameConstants();
        gameEngine = new GameEngine();

    }

    public static void setFameConstants(){
        AppConstant.gravity = 3;
        AppConstant.VELOCITY_WHEN_JUMPED = -40;
        gapBetweenTopAndBottomTubes = 600;

        AppConstant.numberOfTubes = 2;
        AppConstant.tubeVelocity = 12;
        AppConstant.minTubeOffsetY = (int)(AppConstant.gapBetweenTopAndBottomTubes / 2.0);
        AppConstant.maxTubeOffsetY = AppConstant.SCREEN_HEIGHT - AppConstant.minTubeOffsetY - AppConstant.gapBetweenTopAndBottomTubes;

        AppConstant.distanceBetweenTubes = AppConstant.SCREEN_HEIGHT * 3/4;
    }


    //Return BITMAPBANK Instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }
    //Return GAMEENGINE INSTANCE
    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize (Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        AppConstant.SCREEN_WIDTH = width;
        AppConstant.SCREEN_HEIGHT = height;
    }


}
