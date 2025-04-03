package models;

import storage.Storage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordGenerator {
    public static String getWord() {
        Random random = new Random();
        ArrayList<String> words = Storage.getWords();
        int randomIndex = Math.abs(random.nextInt()) % words.size();
        return words.get(randomIndex);
    }

    public static char[] generateMaskedWord(String actualWord) {
        char[] maskedWord = actualWord.toCharArray();
        Arrays.fill(maskedWord, '_');
        return maskedWord;
    }
}
