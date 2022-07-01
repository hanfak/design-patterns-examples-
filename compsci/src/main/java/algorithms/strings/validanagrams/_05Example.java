package algorithms.strings.validanagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class _05Example {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char charInString1 : s.toCharArray()) {
            map.put(charInString1, map.getOrDefault(charInString1, 0) + 1);
        }
        for (char charInString2 : t.toCharArray()) {
            if (map.get(charInString2) == null || map.get(charInString2) == 0) {
                return false;
            }
            map.put(charInString2, map.getOrDefault(charInString2, 0) - 1);
        }
        for (char key : map.keySet()) {
            if (map.get(key) > 0) {
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
