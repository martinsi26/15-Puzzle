package com.example.a15puzzle;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ViewListener implements View.OnClickListener{

    private Button[] gameButtons = new Button[16];
    private ArrayList<Integer> nums;

    public ViewListener(Button[] _gameButtons) {
        nums = new ArrayList<>();
        for(int i = 1; i <= 16; i++) {
            nums.add(i);
        }
        for(int i = 0; i < _gameButtons.length; i++) {
            gameButtons[i] = _gameButtons[i];
        }
        Collections.shuffle(nums);
        for(int i = 0; i < gameButtons.length; i++) {
            if(nums.indexOf(i + 1) != 0) {
                gameButtons[i].setText(String.valueOf(nums.indexOf(i + 1)));
            } else {
                gameButtons[i].setText("");
            }
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.newGame) {
            Collections.shuffle(nums);
            for(int i = 0; i < gameButtons.length; i++) {
                if(nums.indexOf(i + 1) != 0) {
                    gameButtons[i].setText(String.valueOf(nums.indexOf(i + 1)));
                } else {
                    gameButtons[i].setText("");
                }
            }
        }
    }
}
