package algorithms.strings.validanagrams;

import java.util.Objects;
import java.util.stream.IntStream;

public class _04Example {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // Depending on the character list, this array will be a certain size
        int[] charsIndexes = new int[256]; // https://www.ssec.wisc.edu/~tomw/java/unicode.html
        for (char charInString1 : s.toCharArray()) {
            charsIndexes[charInString1] += 1;
        }
        for (char charInString2 : t.toCharArray()) {
            charsIndexes[charInString2] -= 1;
        }
        for (int i : charsIndexes) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String... args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println("anagram = " + anagram);
        long nrChars = IntStream.rangeClosed(0, 0x10ffff)
                .mapToObj(Character.UnicodeBlock::of)
                .filter(Objects::nonNull)
                .count();
        System.out.println("nrChars = " + nrChars);
    }
}
