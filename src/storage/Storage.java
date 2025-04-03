package storage;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<String> words = new ArrayList<>();

    public static ArrayList<String> getWords() {
        return new ArrayList<>(words);
    }

    public static void addWord(String word) {
        words.add(word);
    }
}
