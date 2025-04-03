package gui.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import models.Game;

public class DisplayWord extends HBox {
    private final Game game;
    public DisplayWord(Game game, double spacing) {
        super(spacing);
        this.game = game;
        setLayout();
        setMaskedWord();
    }

    private void setLayout() {
        setAlignment(Pos.CENTER);
    }

    protected void setMaskedWord() {
        getChildren().clear();
        char[] maskedWord = game.getMaskedWord();
        for (char letter : maskedWord) {
            Label label = new Label(String.valueOf(letter));
            label.setFont(Font.font("Arial", FontWeight.BOLD, 40));

            getChildren().add(label);
        }
    }

}
