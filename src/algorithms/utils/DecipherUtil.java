package algorithms.utils;

import algorithms.InputData;

import java.util.*;

/**
 * @author : Ana Kalemi
 **/
public class DecipherUtil {
    private final Set<String> dictionary;
    private final int maxLength;

    final Map<String, List<String>> memo = new HashMap<>();

    public DecipherUtil(InputData inputData) {
        this.dictionary = inputData.getDictionary();
        this.maxLength = inputData.getMaxDictWordLength();
    }

    /**
     * Returns a list of all possible outcomes of deciphering the corrupted text
     * after consulting a given dictionary
     * @custom.precondition A dictionary must be provided
     * @custom.postcondition The potential outcomes need not make logical sense.
     *
     * @param text the corrupted text that needs to be deciphered
     * @return all the potential outcomes after deciphering
     */
    public List<String> decipher(String text) {
        if (memo.get(text) != null) {
            return memo.get(text);
        }
        List<String> result = new ArrayList<>();
        if (dictionary.contains(text)) {
            result.add(text);
        }
        StringBuilder word = new StringBuilder();
        for (int i = 1; i <= maxLength && i < text.length(); i++) {
            word.append(text.charAt(i - 1));
            if (dictionary.contains(word.toString())) {
                List<String> temp = decipher(text.substring(i));
                for (String s : temp) {
                    result.add(word + " " + s);
                }
            }
        }
        memo.put(text, result);
        return result;
    }

}