package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.WordGenerator;

public class StartWindow extends Application {
    private WordGenerator wordGenerator;
    private HangManDrawing hangManDrawing;
    private DisplayWord displayWord;
    private KeyboardUI keyboardUI;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("HangMan!");

        BorderPane borderPane = new BorderPane();
        initContent(borderPane);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initContent(BorderPane borderPane) {
        wordGenerator = new WordGenerator("resources/da_nouns.txt");
        hangManDrawing = new HangManDrawing(250, 250);
        displayWord = new DisplayWord(wordGenerator,20);
        keyboardUI = new KeyboardUI(wordGenerator, displayWord, hangManDrawing);

        borderPane.setLeft(hangManDrawing);
        borderPane.setBottom(keyboardUI);
        borderPane.setCenter(displayWord);
        BorderPane.setAlignment(displayWord, Pos.CENTER_RIGHT);
    }
}
