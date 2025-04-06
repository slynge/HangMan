package gui.components;

import application.controller.Controller;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import application.models.Game;
import application.models.GameState;


public class KeyboardUI extends GridPane {
    private final Game game;
    private final DisplayWord displayWord;
    private final HangManDrawing hangManDrawing;
    protected KeyboardUI(Game game, DisplayWord displayWord, HangManDrawing hangManDrawing) {
        this.game = game;
        this.displayWord = displayWord;
        this.hangManDrawing = hangManDrawing;
        setKeyboard();
    }

    private void setKeyboard() {
        String[] alphabet = {"A", "B", "C", "D","E", "F",
                           "G", "H", "I", "J", "K", "L",
                           "M", "N", "O", "P", "Q", "R",
                           "S", "T", "U", "V", "W", "X",
                           "Y", "Z", "Æ", "Ø", "Å"};
        int rowNr = 1;
        int colNr = 1;
        for (String letter : alphabet) {
            Button letterButton = createButton(letter, 85, 85, 35);
            letterButton.setOnAction(event -> updateMaskedWord(game, displayWord, hangManDrawing, letterButton));
            add(letterButton, colNr, rowNr);
            if(colNr % 10 == 0) {
                colNr = 1;
                rowNr++;
            }
            else {
                colNr++;
            }
        }
        Button newGameButton = createButton(" New\nGame", 85, 85, 20);
        add(newGameButton, colNr, rowNr);
        newGameButton.setOnAction(event -> restartGame());
    }

    private void restartGame() {
        Controller.restartGame(game);
        displayWord.setMaskedWord();
        hangManDrawing.clear();
        setButtons(true);
    }

    private void updateMaskedWord(Game game, DisplayWord displayWord, HangManDrawing hangManDrawing, Button button) {
        char chosenLetter = button.getText().charAt(0);
        if(Controller.chooseLetter(game, chosenLetter)) {
            displayWord.setMaskedWord();
        }
        else {
            hangManDrawing.draw();
            if(game.getGameState() == GameState.LOST) {
                setButtons(false);
            }
        }
        button.setDisable(true);
    }

    private void setButtons(boolean val) {
        for (Node child : getChildren()) {
            if(child instanceof Button button && !button.getText().contains("New\nGame")) {
                button.setDisable(!val);
            }
        }
    }

    private Button createButton(String text, int widthOfButton, int heightOfButton, int textSize) {
        Button buttonForLetter = new Button(text);
        buttonForLetter.setMinSize(widthOfButton, heightOfButton);
        buttonForLetter.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        return buttonForLetter;
    }
}
