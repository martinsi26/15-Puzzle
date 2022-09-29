package com.example.a15puzzle;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 15 Puzzle: creates a 4v4 puzzle game in which you order the numbers from 1 - 15
 *
 * @author **** Simon Martin ****
 * @version **** 9/26/22 ****
 */

public class ViewListener implements View.OnClickListener{

    private Button[][] gameButtons; // array of buttons for each of the squares
    private ArrayList<Integer> nums; // arraylist of numbers for the 15 different numbered squares
    private ArrayList<Integer> numbers; // arraylist of numbers to check if the puzzle is solvable
    private ArrayList<Integer> adjacent; // arraylist of all numbers adjacent to the open square
    private int blankX; // x value of the open square
    private int blankY; // y value of the open square
    private int count; // counter for checking if the puzzle is solvable

    /**
     * constructor that displays all the buttons on the screen in a random order
     * @param _gameButtons the 15 buttons on the screen
     */
    public ViewListener(Button[][] _gameButtons) {
        gameButtons = new Button[4][4];
        count = 0;
        nums = new ArrayList<>();
        numbers = new ArrayList<>();

        // adding all numbers to the array 1 - 16
        for(int i = 1; i <= 16; i++) {
            nums.add(i);
        }

        // adding all the buttons
        for(int i = 0; i < _gameButtons.length; i++) {
            gameButtons[i] = _gameButtons[i];
        }

        // randomizing the numbers order so the button numbers can be random
        Collections.shuffle(nums);
        numbers.clear();

        // adding the randomized numbers to a new number arraylist
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) != 0 && nums.get(i) != 16) {
                numbers.add(nums.get(i));
            }
        }

        // check if the current numbers are suitable for a winnable situation
        // if not it randomizes the numbers and checks again until there is a
        // winnable situation
        while(!checkSuitableNumbers()) {
            Collections.shuffle(nums);
            numbers.clear();
            for(int i = 0; i < nums.size(); i++) {
                if(nums.get(i) != 0 && nums.get(i) != 16) {
                    numbers.add(nums.get(i));
                }
            }
        }

        // changes the text of the buttons to the new numbers
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

    /**
     * Checks for the squares around the empty square and adds the numbers to an array
     *
     */
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

    /**
     * Using the x and y values of the square and determines if the square pressed
     * should switch with the empty square and moves it
     * @param screenX x value of the button clicked
     * @param screenY y value of the button clicked
     */
    public void changeNumbers(float screenX, float screenY) {
        int x = 0;
        int y = 0;

        // sets the x and y values to integer values that can be used in the 2d array of buttons
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

        // checks if the button is apart of the adjacent arraylist meaning it is next to the button
        // so that the button and the empty square can switch places
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

    /**
     * Checks if the position of the button is correct so the color can change
     */
    public void checkCorrectPosition() {
        int color = 0xFFFFA500;

        // if the number is in the right position the color is changed to orange
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

    /**
     * Checks if the solution is winnable by counting
     * @return true if the solution is winnable
     */
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

    /**
     * common onClick method
     * @param view the view of the screen
     */
    @Override
    public void onClick(View view) {

        // checks if any of the number buttons are clicked so they can possibly change with
        // the empty button, otherwise if the newGame button is clicked the buttons are
        // randomized again
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

            // checks for the suitability with the newly changed button layout
            while(!checkSuitableNumbers()) {
                Collections.shuffle(nums);
                numbers.clear();
                for(int i = 0; i < nums.size(); i++) {
                    if(nums.get(i) != 0 && nums.get(i) != 16) {
                        numbers.add(nums.get(i));
                    }
                }
            }

            // changes the color of all the buttons to be blue and make the empty button be
            // blank then changes the colors if they are in the correct position
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
