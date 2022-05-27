package com.example.flappybirdclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView playBtn;
    Button ExitMenu;
    Button AboutMenu;

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppConstant.initialization(this.getApplicationContext());

        playBtn = findViewById(R.id.playBtn);
        AboutMenu = findViewById(R.id.AboutMenu);
        ExitMenu = findViewById(R.id.ExitMenu);

        dialog = new Dialog(MainActivity.this);



        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Play!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);

            }
        });

        AboutMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                About();
            }
        });

        ExitMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EXIT GAME
                finishAffinity();
            }
        });

    }
    /*SHOW DIAOLOG SQUARE*/
    private void About() {

        Button Close;

        dialog.setContentView(R.id.AboutMenu);

        Close = dialog.findViewById(R.id.Close);

        Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

    }

    public void onBackPressed(){
        //IT STAYS EMPTY SO IT DOESN'T GOES BACK
    }
}