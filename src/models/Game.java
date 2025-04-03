package models;
public class Game {
    private int numberOfLives;
    private String actualWord;
    private char[] maskedWord;

    public Game() {
        setGame();
    }

    public int getNumberOfLives() {
        return numberOfLives;
    }

    public String getActualWord() {
        return actualWord;
    }

    public char[] getMaskedWord() {
        return maskedWord;
    }

    public void setMaskedWord(int index, char letter) {
        maskedWord[index] = letter;
    }

    public void decreaseNumberOfLives() {
        numberOfLives--;
    }

    public void setGame() {
        numberOfLives = 10;
        actualWord = WordGenerator.getWord();
        maskedWord = WordGenerator.generateMaskedWord(actualWord);
    }
}
