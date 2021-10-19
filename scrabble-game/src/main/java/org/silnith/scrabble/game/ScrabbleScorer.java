package org.silnith.scrabble.game;

import java.text.Normalizer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class ScrabbleScorer {
    
    public Map<String, Integer> loadAlphabet(Locale locale) {
        final ResourceBundle alphabetBundle = ResourceBundle.getBundle("org.silnith.scrabble.game.AlphabetBundle", locale);
        final Set<String> keySet = alphabetBundle.keySet();
        final Map<String, Integer> letterScores = new HashMap<>(keySet.size());
        for (final String letter : keySet) {
            final Object object = alphabetBundle.getObject(letter);
            final int value;
            if (object instanceof Number) {
                final Number number = (Number) object;
                value = number.intValue();
            } else {
                value = Integer.parseInt(object.toString());
            }
            letterScores.put(Normalizer.normalize(letter, Normalizer.Form.NFC), value);
        }
        return letterScores;
    }
    
    public Collection<String> loadDictionary(Locale locale) {
        final ResourceBundle dictionaryBundle = ResourceBundle.getBundle("org.silnith.scrabble.game.DictionaryBundle", locale);
        return dictionaryBundle.keySet();
    }

}
