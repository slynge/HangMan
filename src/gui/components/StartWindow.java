package gui.components;

import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import application.models.Game;

public class StartWindow extends Application {

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
        Game game = Controller.createGame();
        HangManDrawing hangManDrawing = new HangManDrawing(game, 250, 250);
        DisplayWord displayWord = new DisplayWord(game, 20);
        KeyboardUI keyboardUI = new KeyboardUI(game, displayWord, hangManDrawing);

        borderPane.setLeft(hangManDrawing);
        borderPane.setBottom(keyboardUI);
        borderPane.setCenter(displayWord);
        BorderPane.setAlignment(displayWord, Pos.CENTER_RIGHT);
    }
}
