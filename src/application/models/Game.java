package application.models;

import java.util.Arrays;

public class Game {
    private int numberOfLives;
    private String actualWord;
    private char[] maskedWord;
    private GameState gameState;

    public Game() {
        setGame();
        gameState = GameState.ONGOING;
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public GameState getGameState() {
        return gameState;
    }

    public String getActualWord() {
        return actualWord;
    }

    public char[] getMaskedWord() {
        return maskedWord;
    }

    public void setMaskedWord(int index, char letter) {
        maskedWord[index] = letter;
        if(Arrays.equals(maskedWord, actualWord.toCharArray())) {
            gameState = GameState.WON;
        }
    }

    public void decreaseNumberOfLives() {
        numberOfLives--;
        if(numberOfLives == 0) {
            gameState = GameState.LOST;
        }
    }

    public void setGame() {
        numberOfLives = 10;
        actualWord = WordGenerator.getWord();
        maskedWord = WordGenerator.generateMaskedWord(actualWord);
        gameState = GameState.ONGOING;
    }
}
