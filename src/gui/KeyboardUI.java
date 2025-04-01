package gui;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.WordGenerator;

import static models.Game.updateGame;

public class KeyboardUI extends GridPane {
    private final WordGenerator wordGenerator;
    private final DisplayWord displayWord;
    private final HangManDrawing hangManDrawing;
    public KeyboardUI(WordGenerator wordGenerator, DisplayWord displayWord, HangManDrawing hangManDrawing) {
        this.wordGenerator = wordGenerator;
        this.displayWord = displayWord;
        this.hangManDrawing = hangManDrawing;
        setLayout();
        setKeyboard();
    }

    private void setLayout() {
        setGridLinesVisible(true);
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
            Button button = createButton(letter, 85, 85, 35);
            button.setOnAction(event -> updateGame(wordGenerator, displayWord, hangManDrawing, button));
            add(button, colNr, rowNr);
            if(colNr % 10 == 0) {
                colNr = 1;
                rowNr++;
            }
            else {
                colNr++;
            }
        }
        add(createButton(" New\nGame", 85, 85, 20), colNr, rowNr);
    }

    private Button createButton(String text, int widthOfButton, int heightOfButton, int textSize) {
        Button buttonForLetter = new Button(text);
        buttonForLetter.setMinSize(widthOfButton, heightOfButton);
        buttonForLetter.setFont(Font.font("Arial", FontWeight.BOLD, textSize));
        return buttonForLetter;
    }
}
