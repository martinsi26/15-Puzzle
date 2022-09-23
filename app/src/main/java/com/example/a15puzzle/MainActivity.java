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

        Button[][] gameButtons = new Button[4][4];
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

        gameButtons[0][0] = gameButton1;
        gameButtons[0][1] = gameButton2;
        gameButtons[0][2] = gameButton3;
        gameButtons[0][3] = gameButton4;
        gameButtons[1][0] = gameButton5;
        gameButtons[1][1] = gameButton6;
        gameButtons[1][2] = gameButton7;
        gameButtons[1][3] = gameButton8;
        gameButtons[2][0] = gameButton9;
        gameButtons[2][1] = gameButton10;
        gameButtons[2][2] = gameButton11;
        gameButtons[2][3] = gameButton12;
        gameButtons[3][0] = gameButton13;
        gameButtons[3][1] = gameButton14;
        gameButtons[3][2] = gameButton15;
        gameButtons[3][3] = gameButton16;

        ViewListener viewListener = new ViewListener(gameButtons);
        newGame.setOnClickListener(viewListener);
    }
}