package org.silnith.scrabble.game;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

public class Main {

    public static void main(final String[] args) {
        final ScrabbleScorer scrabbleScorer = new ScrabbleScorer();
        final Map<String, Integer> alphabet = scrabbleScorer.loadAlphabet(Locale.US);
        System.out.println(alphabet);
        final Collection<String> dictionary = scrabbleScorer.loadDictionary(Locale.US);
        for (final String word : dictionary) {
            System.out.println(word);
        }
        System.out.println(String.format(Locale.US, "%,d words in the dictionary", dictionary.size()));
    }

}
