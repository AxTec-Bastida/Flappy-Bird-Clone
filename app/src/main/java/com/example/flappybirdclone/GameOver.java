package com.example.flappybirdclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    ImageView PlayAgain;
    TextView Points, BestScore;
    Button Btn_Exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_game_over);

        PlayAgain = findViewById(R.id.PlayAgain);
        Points = findViewById(R.id.Points);
        BestScore = findViewById(R.id.BestScore);
        Btn_Exit = findViewById(R.id.Btn_Exit);

        int points = getIntent().getExtras().getInt("Points");
        SharedPreferences sharedPreferences = getSharedPreferences("Preference", 0);
        int pointsSP = sharedPreferences.getInt("pointsSP", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(points > pointsSP){
            pointsSP = points;
            editor.putInt("pointSP", pointsSP);
            editor.commit();
        }

        Points.setText(""+points);
        BestScore.setText(""+pointsSP);

        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EXIT COMPLETELY FROM THE GAME
                finishAffinity();
            }
        });

    }

    @Override
    public void onBackPressed(){
        //NOT GOING ACK
    }


}