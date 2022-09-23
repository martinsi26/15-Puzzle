package com.example.a15puzzle;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ViewListener implements View.OnClickListener{

    private Button[][] gameButtons = new Button[4][4];
    private ArrayList<Integer> nums;
    private int[] correctButtons = new int[4];

    public ViewListener(Button[][] _gameButtons) {
        nums = new ArrayList<>();
        for(int i = 1; i <= 16; i++) {
            nums.add(i);
        }
        for(int i = 0; i < _gameButtons.length; i++) {
            gameButtons[i] = _gameButtons[i];
        }
        Collections.shuffle(nums);
        int counter = 1;
        for(int row = 0; row < gameButtons.length; row++) {
            for(int col = 0; col < gameButtons[row].length; col++) {
                if (nums.indexOf(counter) != 0) {
                    gameButtons[row][col].setText(String.valueOf(nums.indexOf(counter)));
                } else {
                    gameButtons[row][col].setText("");
                }
                counter++;
            }
        }
    }

    public int[] checkEmpty() {
        for(int row = 0; row < gameButtons.length; row++) {
            for (int col = 0; col < gameButtons[row].length; col++) {
                if(gameButtons[row][col].getText() != "") {
                    if(row > 0) {
                        if(gameButtons[row - 1][col].getText() == "") {

                        } else {

                        }
                    }
                }
            }
        }
        return correctButtons;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.newGame) {
            Collections.shuffle(nums);
            int counter = 1;
            for(int row = 0; row < gameButtons.length; row++) {
                for(int col = 0; col < gameButtons[row].length; col++) {
                    if (nums.indexOf(counter) != 0) {
                        gameButtons[row][col].setText(String.valueOf(nums.indexOf(counter)));
                    } else {
                        gameButtons[row][col].setText("");
                    }
                    counter++;
                }
            }
        }
        for(int row = 0; row < gameButtons.length; row++) {
            for (int col = 0; col < gameButtons[row].length; col++) {
                if(gameButtons[row][col].getText() != "") {
                    if(gameButtons[row - 1][col].getText() == "") {

                    }
                }
            }
        }
    }
}
