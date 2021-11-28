package functional.com.chapter3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class FunctionExamples {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hi", "hello", "hola", "bye", "goodbye", "adios");
        System.out.println("Original words: " + words);

        Function<String, String> stringStringFunction = s -> s + "!";
        List<String> excitingWords = StringTwoUtils.transformedList(words, stringStringFunction);
        System.out.printf("Exciting words: %s.%n", excitingWords);

        List<String> eyeWords = StringTwoUtils.transformedList(words, s -> s.replace("i", "eye"));
        System.out.printf("Eye words: %s.%n", eyeWords);

        List<String> upperCaseWords =StringTwoUtils.transformedList(words, String::toUpperCase);
        System.out.printf("Uppercase words: %s.%n", upperCaseWords);
    }
}

