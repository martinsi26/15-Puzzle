package com.example.a15puzzle;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class ViewListener implements View.OnClickListener{

    private Button[][] gameButtons = new Button[4][4];
    private ArrayList<Integer> nums;
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> adjacent;
    private int blankX;
    private int blankY;
    private int count;

    public ViewListener(Button[][] _gameButtons) {
        count = 0;
        nums = new ArrayList<>();
        numbers = new ArrayList<>();
        for(int i = 1; i <= 16; i++) {
            nums.add(i);
        }
        for(int i = 0; i < _gameButtons.length; i++) {
            gameButtons[i] = _gameButtons[i];
        }

        Collections.shuffle(nums);
        numbers.clear();
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) != 0 && nums.get(i) != 16) {
                numbers.add(nums.get(i));
            }
        }

        while(!checkSuitableNumbers()) {
            Collections.shuffle(nums);
            numbers.clear();
            for(int i = 0; i < nums.size(); i++) {
                if(nums.get(i) != 0 && nums.get(i) != 16) {
                    numbers.add(nums.get(i));
                }
            }
        }

        int counter = 0;
        for(int row = 0; row < gameButtons.length; row++) {
            for(int col = 0; col < gameButtons[row].length; col++) {
                if (nums.get(counter) != 16) {
                    gameButtons[row][col].setText(String.valueOf(nums.get(counter)));
                    gameButtons[row][col].setBackgroundColor(0xFFADD8E6);
                } else {
                    gameButtons[row][col].setText("");
                    gameButtons[row][col].setBackgroundColor(0x00);
                }
                counter++;
            }
        }
        checkCorrectPosition();
    }

    public void checkEmptyAdjacent() {
        adjacent = new ArrayList<>();
        for(int row = 0; row < gameButtons.length; row++) {
            for (int col = 0; col < gameButtons[row].length; col++) {
                if(gameButtons[row][col].getText() == "") {
                    blankX = col;
                    blankY = row;
                    if(row > 0) {
                        adjacent.add(Integer.parseInt(gameButtons[row - 1][col].getText().toString()));
                    }
                    if (col > 0) {
                        adjacent.add(Integer.parseInt(gameButtons[row][col - 1].getText().toString()));
                    }
                    if (row < gameButtons.length - 1) {
                        adjacent.add(Integer.parseInt(gameButtons[row + 1][col].getText().toString()));
                    }
                    if (col < gameButtons[row].length - 1) {
                        adjacent.add(Integer.parseInt(gameButtons[row][col + 1].getText().toString()));
                    }
                }
            }
        }
    }

    public void changeNumbers(float screenX, float screenY) {
        int x = 0;
        int y = 0;
        if(screenY == 100) {
            y = 0;
        } else if(screenY == 99) {
            y = 1;
        } else if(screenY == 98) {
            y = 2;
        } else if(screenY == 97) {
            y = 3;
        }
        if(screenX == 128.0) {
            x = 0;
        } else if(screenX == 380.0) {
            x = 1;
        } else if(screenX == 632.0) {
            x = 2;
        } else if(screenX == 884.0) {
            x = 3;
        }
        for(int i = 0; i < adjacent.size(); i++) {
            if (gameButtons[y][x].getText() != "") {
                if (Integer.parseInt(gameButtons[y][x].getText().toString()) == adjacent.get(i)) {
                    gameButtons[blankY][blankX].setText(gameButtons[y][x].getText());
                    gameButtons[blankY][blankX].setBackgroundColor(0xFFADD8E6);
                    gameButtons[y][x].setText("");
                    gameButtons[y][x].setBackgroundColor(0x00);
                    break;
                }
            }
        }
    }

    public void checkCorrectPosition() {
        int color = 0xFFFFA500;
        for(int i = 0; i < 4; i++) {
            if (gameButtons[0][i].getText().equals(String.valueOf((i + 1)))) {
                gameButtons[0][i].setBackgroundColor(color);
            }
            if (gameButtons[1][i].getText().equals(String.valueOf((i + 5)))) {
                gameButtons[1][i].setBackgroundColor(color);
            }
            if (gameButtons[2][i].getText().equals(String.valueOf((i + 9)))) {
                gameButtons[2][i].setBackgroundColor(color);
            }
            if (gameButtons[3][i].getText().equals(String.valueOf((i + 13)))) {
                gameButtons[3][i].setBackgroundColor(color);
            }
        }
    }

    public boolean checkSuitableNumbers() {
        count = 0;
        for(int i = 0; i < numbers.size(); i++) {
            for (int j = i; j < numbers.size(); j++) {
                if (numbers.get(i) > numbers.get(j)) {
                    count++;
                }
            }
        }
        if(count % 2 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view) {
        if(view.getId() != R.id.newGame) {
            checkEmptyAdjacent();
            changeNumbers(view.getX(), view.getAlpha());
        } else if(view.getId() == R.id.newGame) {
            Collections.shuffle(nums);
            numbers.clear();
            for(int i = 0; i < nums.size(); i++) {
                if(nums.get(i) != 0 && nums.get(i) != 16) {
                    numbers.add(nums.get(i));
                }
            }
            while(!checkSuitableNumbers()) {
                Collections.shuffle(nums);
                numbers.clear();
                for(int i = 0; i < nums.size(); i++) {
                    if(nums.get(i) != 0 && nums.get(i) != 16) {
                        numbers.add(nums.get(i));
                    }
                }
            }
            int counter = 1;
            for(int row = 0; row < gameButtons.length; row++) {
                for(int col = 0; col < gameButtons[row].length; col++) {
                    if (nums.indexOf(counter) != 0) {
                        gameButtons[row][col].setText(String.valueOf(nums.indexOf(counter)));
                        gameButtons[row][col].setBackgroundColor(0xFFADD8E6);
                    } else {
                        gameButtons[row][col].setText("");
                        gameButtons[row][col].setBackgroundColor(0x00);
                    }
                    counter++;
                }
            }
        }
        checkCorrectPosition();
    }
}
