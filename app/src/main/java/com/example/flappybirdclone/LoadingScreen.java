package com.example.flappybirdclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);


        //2.5 Seconds
        final int LOADING_DURATION = 2500;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //EXECUTE PASSED TIME
                Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
                startActivity(intent);
                //WE GO TO MAIN ACTIVITY

            }
        },LOADING_DURATION);

    }
}