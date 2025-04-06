package application.controller;

import application.models.Game;

public class Controller {
    public static Game createGame() {
        return new Game();
    }

    public static void restartGame(Game game) {
        game.setGame();
    }

    public static boolean chooseLetter(Game game, char letter) {
        String actualWord = game.getActualWord();
        if(actualWord.contains(String.valueOf(letter))) {
            for (int index = 0; index < actualWord.length(); index++) {
                if(actualWord.charAt(index) == letter) {
                    game.setMaskedWord(index, letter);
                }
            }
            return true;
        }
        game.decreaseNumberOfLives();
        return false;
    }
}
