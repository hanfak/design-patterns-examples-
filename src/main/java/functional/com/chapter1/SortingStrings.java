package functional.com.chapter1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStrings {

    public final String[] testStrings = {"one", "two", "three", "four"};
    public final String[] testStringsTwo = {"one", "two", "three", "four"};


    public static void main(String[] args) {
        SortingStrings sortingStrings = new SortingStrings();
        System.out.println("Mutating array");
        System.out.println("Before sorting " + showArray(sortingStrings.testStrings));
        // Same as below
        // Arrays.sort(testStrings, (s1, s2) -> s1.length() - s2.length());
        // mutating testStrings
        Arrays.sort(sortingStrings.testStrings, Comparator.comparingInt(String::length));
        System.out.println("After Sorting "  + showArray(sortingStrings.testStrings));

        System.out.println("\nNot mutating");
        System.out.println("Before sorting " + showArray(sortingStrings.testStringsTwo));
        List<String> sortedArray = Arrays.stream(sortingStrings.testStringsTwo)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("After sorting, original array " + showArray(sortingStrings.testStringsTwo));
        System.out.println("After sorting, new array created " + showArray(sortedArray));


        String[] words = { "hi", "hello", "hola", "bye", "goodbye", "adios" };
        System.out.println("\nOriginal array: " +
                Arrays.asList(words));

        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        System.out.println("Sorted by length ascending: " +
                Arrays.asList(words));

        Arrays.sort(words, Comparator.comparingInt(String::length));
        System.out.println("Sorted by length ascending, using comparator: " +
                Arrays.asList(words));

        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        System.out.println("Sorted by length descending : " +
                Arrays.asList(words));

        Arrays.sort(words, Comparator.comparingInt(String::length).reversed());
        System.out.println("Sorted by length descending, using reverse : " +
                Arrays.asList(words));

        Arrays.sort(words, (s1, s2) -> s1.charAt(0) - s2.charAt(0));
        System.out.println("Sorted by first letter : " +
                Arrays.asList(words));

        Arrays.sort(words, Comparator.comparingInt(s -> s.charAt(0)));
        System.out.println("Sorted by first letter using comparator : " +
                Arrays.asList(words));

        Arrays.sort(words, (s1, s2) ->
        { int compareFlag = 0;
            if(s1.contains("e") && !s2.contains("e")) {
                compareFlag = -1;
            } else if(s2.contains("e") && !s1.contains("e")) {
                compareFlag = 1;
            }
            return(compareFlag);
        });
        System.out.println("\nSorted by whether it contains 'e' : " +
                Arrays.asList(words));



        Arrays.sort(words, stringComparator());
        System.out.println("\nSorted by whether it contains 'e' lambda extracted: " +
                Arrays.asList(words));
    }

    private static String showArray(List<String> sortedArray) {
        return sortedArray.stream().collect(Collectors.joining(", "));
    }

    private static String showArray(String[] array) {
        return Arrays.stream(array).collect(Collectors.joining(", "));
    }

    private static Comparator<String> stringComparator() {
        return (s1, s2) ->
        {
            int compareFlag = 0;
            if (s1.contains("e") && !s2.contains("e")) {
                compareFlag = -1;
            } else if (s2.contains("e") && !s1.contains("e")) {
                compareFlag = 1;
            }
            return (compareFlag);
        };
    }
}
