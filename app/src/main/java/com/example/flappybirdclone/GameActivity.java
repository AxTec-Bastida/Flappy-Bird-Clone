package com.example.flappybirdclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameActivity extends AppCompatActivity {

    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        AppConstant.gameActivityContext = this;
        gameView = new GameView(this);
        setContentView(gameView);
    }
}