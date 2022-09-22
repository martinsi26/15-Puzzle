package com.example.a15puzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button[] gameButtons = new Button[16];
        Button gameButton1 = findViewById(R.id.gameButton1);
        Button gameButton2 = findViewById(R.id.gameButton2);
        Button gameButton3 = findViewById(R.id.gameButton3);
        Button gameButton4 = findViewById(R.id.gameButton4);
        Button gameButton5 = findViewById(R.id.gameButton5);
        Button gameButton6 = findViewById(R.id.gameButton6);
        Button gameButton7 = findViewById(R.id.gameButton7);
        Button gameButton8 = findViewById(R.id.gameButton8);
        Button gameButton9 = findViewById(R.id.gameButton9);
        Button gameButton10 = findViewById(R.id.gameButton10);
        Button gameButton11 = findViewById(R.id.gameButton11);
        Button gameButton12 = findViewById(R.id.gameButton12);
        Button gameButton13 = findViewById(R.id.gameButton13);
        Button gameButton14 = findViewById(R.id.gameButton14);
        Button gameButton15 = findViewById(R.id.gameButton15);
        Button gameButton16 = findViewById(R.id.blankButton);
        Button newGame = findViewById(R.id.newGame);

        gameButtons[0] = gameButton1;
        gameButtons[1] = gameButton2;
        gameButtons[2] = gameButton3;
        gameButtons[3] = gameButton4;
        gameButtons[4] = gameButton5;
        gameButtons[5] = gameButton6;
        gameButtons[6] = gameButton7;
        gameButtons[7] = gameButton8;
        gameButtons[8] = gameButton9;
        gameButtons[9] = gameButton10;
        gameButtons[10] = gameButton11;
        gameButtons[11] = gameButton12;
        gameButtons[12] = gameButton13;
        gameButtons[13] = gameButton14;
        gameButtons[14] = gameButton15;
        gameButtons[15] = gameButton16;

        ViewListener viewListener = new ViewListener(gameButtons);
        newGame.setOnClickListener(viewListener);
    }
}