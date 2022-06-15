package algorithms.utils;

import algorithms.InputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author : Ana Kalemi
 **/
public class FileReaderUtil {
    private final String TEST_FILE_01 = "src/algorithms/resources/input_01.txt";
    private final String TEST_FILE_02 = "src/algorithms/resources/input_02.txt";
    private final String TEST_FILE_03 = "src/algorithms/resources/input_03.txt";

    public void getAndProcessFileData() {
        File file = new File(TEST_FILE_02);
        try {
            Scanner scanner = new Scanner(file);
            processFileData(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processFileData(Scanner scanner) {
        try {
            checkAndSetDictSize(scanner);
            checkAndSetCorruptedText(scanner);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        int linesOfDictionary = getInputData().getDictionarySize();
        while (scanner.hasNext() && linesOfDictionary > 0) {

            String word = scanner.next();
            if (getInputData().getMaxDictWordLength() < word.length()) {
                getInputData().setMaxDictWordLength(word.length());
            }
            getInputData().getDictionary().add(word.toLowerCase());

            linesOfDictionary -= 1;
        }
    }

    private void checkAndSetDictSize(Scanner scanner) throws RuntimeException {
        if (scanner.hasNextLine()) {
            int d = scanner.nextInt();
            if ((d >= 0 && d <= 5 * Math.pow(10, 4))) {
                getInputData().setDictionarySize(d);
            } else {
                throw new RuntimeException("The dictionary size is out of range!");
            }
        }
    }

    private void checkAndSetCorruptedText(Scanner scanner) throws RuntimeException {
        if (scanner.hasNextLine()) {
            String s = scanner.next();
            if (s.length() > 0 && s.length() <= Math.pow(10, 3)) {
                getInputData().setCorruptedText(s);
            } else {
                throw new RuntimeException("The corrupted text size is out of range!");
            }
        }
    }

    public InputData getInputData() {
        return InputData.getInstance();
    }

}
