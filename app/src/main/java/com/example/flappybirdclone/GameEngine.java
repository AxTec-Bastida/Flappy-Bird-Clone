package com.example.flappybirdclone;

import android.app.Activity;
import android.app.appsearch.AppSearchBatchResult;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;

    Bird bird;

    static int gameState;

    ArrayList<Tube> tubes;
    Random random;

    //STORE SCORE
    int score;
    //KEEP TRACK OF SCORING TUBE
    int scoringTube;

    Paint scorePaint;

    public GameEngine(){

        backgroundImage = new BackgroundImage();
        bird = new Bird();

        //0 = Not Started
        //1 = Playing
        //2 = GameOver

        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for(int i = 0; i<AppConstant.numberOfTubes; i++){
            int tubeX=AppConstant.SCREEN_WIDTH + i * AppConstant.distanceBetweenTubes;
            //GET TOPTUBEOFFSETY
            int topTubeOffsetY = AppConstant.minTubeOffsetY + random.nextInt(AppConstant.maxTubeOffsetY - AppConstant.minTubeOffsetY);
            //NOW CREATE TUBE OBJECT
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);
        }

        score = 0;
        scoringTube = 0;

        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(80);
        scorePaint.setTextAlign(Paint.Align.LEFT);

    }

    public void updateAndDrawTubes(Canvas canvas){
        if(gameState == 1){

            if((tubes.get(scoringTube).getTubeX() < bird.getX() + AppConstant.getBitmapBank().getBirdHeight()) && (tubes.get(scoringTube).getTopTubeOffsetY() >
                    bird.getY() || tubes.get(scoringTube).getBottomTubeY() < (bird.getY() + AppConstant.getBitmapBank().getBirdHeight()))){
                        //GO TO GAME OVER SCREN
                        gameState = 2;
                       // Log.d("PLAYER", "YOU LOST");
                        AppConstant.getSoundBank().playHit();
                         Context context = AppConstant.gameActivityContext;

                        Intent intent = new Intent(context, GameOver.class);
                        intent.putExtra("Score",score);
                        context.startActivity(intent);
                        ((Activity) context).finish();


            }

            else if(tubes.get(scoringTube).getTubeX() < bird.getX() - AppConstant.getBitmapBank().getTubeWidth()){
                score++;
                scoringTube++;
                if (scoringTube > AppConstant.numberOfTubes - 1){
                    scoringTube = 0;
                }
                AppConstant.getSoundBank().playPoint();
            }
            for (int i =0; i <AppConstant.numberOfTubes; i++){
                if(tubes.get(i).getTubeX() <- AppConstant.getBitmapBank().getTubeWidth()){
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstant.numberOfTubes * AppConstant.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstant.minTubeOffsetY + random.nextInt(AppConstant.maxTubeOffsetY - AppConstant.minTubeOffsetY + 1);

                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                    tubes.get(i).setTubeColor();
                }

                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstant.tubeVelocity);

                if(tubes.get(i).getTubeColor() == 0){
                    canvas.drawBitmap(AppConstant.getBitmapBank().getTubeTop(),tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(),null);
                    canvas.drawBitmap(AppConstant.getBitmapBank().getTubeBottom(),tubes.get(i).getTubeX(),tubes.get(i).getBottomTubeY(),null);
                }else {
                    canvas.drawBitmap(AppConstant.getBitmapBank().getRedTubeTop(),tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(),null);
                    canvas.drawBitmap(AppConstant.getBitmapBank().getRedTubeBottom(),tubes.get(i).getTubeX(),tubes.get(i).getBottomTubeY(),null);
                }

            }

            canvas.drawText("Points: "+ score, 20,110,scorePaint);

        }
    }

    public  void updateAndDrawableBackgroundImage(Canvas canvas){
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if(backgroundImage.getX() <- AppConstant.getBitmapBank().getBackgroundWidth()){
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstant.getBitmapBank().getBackground_game(), backgroundImage.getX(),backgroundImage.getY(),null);

        if(backgroundImage.getX() <- (AppConstant.getBitmapBank().getBackgroundWidth() - AppConstant.SCREEN_WIDTH)){
            canvas.drawBitmap(AppConstant.getBitmapBank().getBackground_game(), backgroundImage.getX()+AppConstant.bitmapBank.getBackgroundWidth(),backgroundImage.getY(),null);
        }

    }

    public void updateAndDrawBird(Canvas canvas){
        if(gameState == 1){
            if(bird.getY() < (AppConstant.SCREEN_HEIGHT - AppConstant.getBitmapBank().getBirdHeight())
            || bird.getVelocity() < 0){
                bird.setVelocity(bird.getVelocity()+AppConstant.gravity);
                bird.setY(bird.getY() + bird.getVelocity());
            }
        }

        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstant.getBitmapBank().getBird(currentFrame), bird.getX(),bird.getY(),null);
        currentFrame++;
        //IF IT EXCEEDS MAX-FRAME RE-INITIALIZE TO 0
        if(currentFrame > bird.maxFrame){
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);

    }
}
