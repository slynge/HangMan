package gui;

import javafx.application.Application;
import storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        initStorage("resources/da_nouns.txt");
        Application.launch(StartWindow.class);
    }

    private static void initStorage(String pathName) {
        File file = new File(pathName);
        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                String word = scanner.next().toUpperCase();
                if(isSuitableWord(word)) {
                    Storage.addWord(word);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isSuitableWord(String word) {
        boolean isBetween3And12Letters = 2 < word.length() && word.length() < 13;
        boolean containsOnlyLetters = word.chars().allMatch(letter -> (letter >= 65 && letter <= 90) // A-Z
                || letter == 198 || letter == 216 || letter == 197); // Æ, Ø, Å
        return isBetween3And12Letters && containsOnlyLetters;
    }
}
