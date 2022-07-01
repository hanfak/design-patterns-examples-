package algorithms.strings.validanagrams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class _02Example {
    // Sorting best case O(nlgn)
    // space = O(2n)
    public static boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;
        char[] tempArray1 = s.toCharArray();
        char[] tempArray2 = t.toCharArray();
        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);
        String string1 = new String(tempArray1);
        String string2 = new String(tempArray2);
        return string1.equals(string2);
    }

    public static void main(String... args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println("anagram = " + anagram);
    }
}
