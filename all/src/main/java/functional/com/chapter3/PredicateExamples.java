package functional.com.chapter3;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hanfak on 02/07/2017.
 */
public class PredicateExamples {
    public static void main(String[] args) {
        List<String> words =
                Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
        System.out.printf("Original words: %s.%n", words);
        List<String> shortWords2 =
                ElementUtils.allMatches(words, s -> s.length() < 4);
        System.out.printf("Short words: %s.%n", shortWords2);
        List<String> wordsWithB2 =
                ElementUtils.allMatches(words, s -> s.contains("b"));
        System.out.printf("B words: %s.%n", wordsWithB2);
        List<String> evenLengthWords2 =
                ElementUtils.allMatches(words, s -> (s.length() % 2) == 0);
        System.out.printf("Even-length words: %s.%n", evenLengthWords2);
        List<Integer> nums = Arrays.asList(1, 10, 100, 1000, 10000);
        List<Integer> bigNums =
                ElementUtils.allMatches(nums, n -> n > 500);
        System.out.printf("Nums bigger than 500: %s.%n", bigNums);
    }
}
