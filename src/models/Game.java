package models;

import gui.DisplayWord;
import gui.HangManDrawing;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Game {
    private static int numberOfLives = 10;

    public static void decreaseNumberOfLives() {
        numberOfLives--;
    }

    public static int getNumberOfLives() {
        return numberOfLives;
    }

    public static void updateGame(WordGenerator wordGenerator, DisplayWord displayWord, HangManDrawing hangManDrawing, Button button) {
        String chosenLetter = button.getText();
        if(WordChecker.isChosenLetterInWord(wordGenerator.getChosenWord(), chosenLetter)) {
            updateWord(displayWord, chosenLetter);
        }
        else {
            decreaseNumberOfLives();
            hangManDrawing.draw();

        }
        button.setDisable(true);
    }

    private static void updateWord(DisplayWord displayWord, String chosenLetter) {
        for (Node child : displayWord.getChildren()) {
            if(child instanceof Label label && label.getText().equals("_")) {
                if(label.getUserData().equals(chosenLetter)) {
                    label.setText(chosenLetter);
                }
            }
        }
    }
}
