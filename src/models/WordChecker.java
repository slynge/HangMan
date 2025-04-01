package models;

public class WordChecker {
    public static boolean isChosenLetterInWord(String word, String chosenLetter) {
        return word.contains(chosenLetter);
    }
}
