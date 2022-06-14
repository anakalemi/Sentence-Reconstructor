import algorithms.InputData;
import algorithms.utils.DecipherUtil;
import algorithms.utils.FileReaderUtil;

import java.util.*;

/**
 * @author : Ana Kalemi
 **/
public class SentenceReconstructorApp {

    public static void main(String[] args) {

        FileReaderUtil fileReader = new FileReaderUtil();
        fileReader.getAndProcessFileData();
        InputData inputData = fileReader.getInputData();

        System.out.println("Dictionary: " + inputData.getDictionary());
        System.out.println("Corrupted Text: " + inputData.getCorruptedText());

        DecipherUtil util = new DecipherUtil(inputData);
        List<String> sentences = util.decipher(inputData.getCorruptedText());

        System.out.println("\nPotential solution(s): " + sentences.size());

        for (String sentence : sentences) {
            System.out.println(sentence);
        }

    }

}


