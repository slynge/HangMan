package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class WordGenerator {
    private final String chosenWord;

    public WordGenerator(String pathName) {
        ArrayList<String> words = getWordsFromFile(pathName);
        chosenWord = chooseWord(words);
    }

    public String getChosenWord() {
        return chosenWord;
    }

    private ArrayList<String> getWordsFromFile(String pathName) {
        File file = new File(pathName);
        ArrayList<String> words = new ArrayList<>();
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                String word = scanner.next().toUpperCase();
                if(isSuitableWord(word)) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return words;
    }

    private boolean isSuitableWord(String word) {
        boolean isBetween3And12Letters = 2 < word.length() && word.length() < 13;
        boolean containsOnlyLetters = word.chars().allMatch(letter -> (letter >= 65 && letter <=90) // A-Z
                                                                       || letter == 198 || letter == 216 || letter == 197); // Æ, Ø, Å
        return isBetween3And12Letters && containsOnlyLetters;
    }

    public String chooseWord(ArrayList<String> words) {
        Random random = new Random(12345);
        int randomIndex = Math.abs(random.nextInt()) % words.size();
        return words.get(randomIndex);
    }



}
