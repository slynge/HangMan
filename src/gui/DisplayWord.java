package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.WordGenerator;

public class DisplayWord extends HBox {
    private final WordGenerator wordGenerator;
    public DisplayWord(WordGenerator wordGenerator, double spacing) {
        super(spacing);
        this.wordGenerator = wordGenerator;
        setLayout();
        setChosenWord();
    }

    private void setLayout() {
        setAlignment(Pos.CENTER);
    }

    private void setChosenWord() {
        String chosenWord = wordGenerator.getChosenWord();
        for (char letter : chosenWord.toCharArray()) {
            Label label = new Label("_");
            label.setUserData(String.valueOf(letter));
            label.setFont(Font.font("Arial", FontWeight.BOLD, 40));

            getChildren().add(label);
        }
    }

}
