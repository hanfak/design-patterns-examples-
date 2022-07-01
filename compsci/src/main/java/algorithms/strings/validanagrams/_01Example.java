package algorithms.strings.validanagrams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _01Example {

    public static boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;
        String[] firstWordChars = s.split("");
        String[] secondWordChars = t.split("");
        return Arrays.stream(firstWordChars).sorted().collect(Collectors.joining()).equals(
        Arrays.stream(secondWordChars).sorted().collect(Collectors.joining()));
    }

    public static void main(String... args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println("anagram = " + anagram);
    }
}
