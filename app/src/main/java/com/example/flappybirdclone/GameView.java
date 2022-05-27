package com.example.flappybirdclone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    GameThread gameThread;

    public GameView(Context context) {
        super(context);

        InitView();


    }



    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {

        if(!gameThread.isRunning()){
            gameThread = new GameThread(surfaceHolder);
            gameThread.start();
        }else {
            gameThread.start();
        }

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

        if(gameThread.isRunning()){
            gameThread.setRunning(false);
            boolean retry = true;
            while(retry){
                try{
                    gameThread.join();
                    retry = false;
                }catch (InterruptedException e){

                }
            }
        }

    }
    void InitView(){

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);

        gameThread = new GameThread(holder);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        //TAP IS DETECTED
        if(action == MotionEvent.ACTION_DOWN){

            if(AppConstant.getGameEngine().gameState == 0){
                AppConstant.getGameEngine().gameState = 1;
                AppConstant.getSoundBank().playSwoosh();
            }else{
                AppConstant.getSoundBank().playWing();
            }

            AppConstant.getGameEngine().gameState = 1;
            AppConstant.getGameEngine().bird.setVelocity(AppConstant.VELOCITY_WHEN_JUMPED);
        }
        return  true;
    }
}
