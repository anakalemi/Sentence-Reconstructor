package algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Ana Kalemi
 **/
public class InputData {
    private String corruptedText = "";
    private int dictionarySize = 0;
    private int maxDictWordLength = 0;

    private Set<String> dictionary = new HashSet<>();

    private static class LazyHolder {
        static final InputData INSTANCE = new InputData();
    }

    public static InputData getInstance() {
        return InputData.LazyHolder.INSTANCE;
    }

    public String getCorruptedText() {
        return corruptedText;
    }

    public void setCorruptedText(String corruptedText) {
        this.corruptedText = corruptedText;
    }

    public int getDictionarySize() {
        return dictionarySize;
    }

    public void setDictionarySize(int dictionarySize) {
        this.dictionarySize = dictionarySize;
    }

    public Set<String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Set<String> dictionary) {
        this.dictionary = dictionary;
    }

    public int getMaxDictWordLength() {
        return maxDictWordLength;
    }

    public void setMaxDictWordLength(int maxDictWordLength) {
        this.maxDictWordLength = maxDictWordLength;
    }
}
