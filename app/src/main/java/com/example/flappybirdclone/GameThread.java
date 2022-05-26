package com.example.flappybirdclone;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{
    //SurfaceHolder makes a reference to the Object
    SurfaceHolder surfaceHolder;

    //A Flag for detection of the thread; if its running or not
    boolean isRunning;

    //Start time Loop and Loop duration
    long startTime, loopTime;
    //Delay in milliseconds between screen refresh
    long DELAY = 33;

    public  GameThread (SurfaceHolder surfaceHolder){

        this.surfaceHolder = surfaceHolder;
        isRunning = true;

    }

    @Override
    public void run() {
        //Loop until Boolean is false
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            //Locking the canvas
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstant.getGameEngine().updateAndDrawableBackgroundImage(canvas);
                    AppConstant.getGameEngine().updateAndDrawBird(canvas);
                    AppConstant.getGameEngine().updateAndDrawTubes(canvas);
                    //Unlock the canvas
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
            //Loop Time
            loopTime = SystemClock.uptimeMillis() - startTime;
            //Pausing here to make sure we update the right amount per second
            if(loopTime < DELAY){
                try{
                    Thread.sleep(DELAY-loopTime);
                }catch (InterruptedException e){
                    Log.e("Interrupted", "Interrupted while sleeping");
                }
            }

        }
    }


    //Return whether the thread is Running
    public boolean isRunning(){
        return isRunning;
    }

    //Set the Thread condition; False = Stopped, True= Running
    public void setRunning(boolean state){
        isRunning = state;
    }


}
