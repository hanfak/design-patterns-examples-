package algorithms.hashtable.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class _03Example {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int ransomNoteLength = ransomNote.length();
        int magazineLength = magazine.length();
        if (ransomNoteLength == 1 && magazineLength == 1) {
            return ransomNote.equals(magazine);
        }
        if (ransomNoteLength > magazineLength) {
            return false;
        }
        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (int i = 0; i < magazineLength; i++) {
            char letter = magazine.charAt(i);
            characterCountMap.put(letter, characterCountMap.getOrDefault(letter, 0) + 1);
        }
        for (int i = 0; i < ransomNoteLength; i++) {
            char letter = ransomNote.charAt(i);
            if (characterCountMap.get(letter) == null || characterCountMap.get(letter) == 0) {
                return false;
            }
            characterCountMap.put(letter, characterCountMap.get(letter) - 1);
        }
        return true;

    }

    public static void main(String... args) {
        boolean b = canConstruct("aea", "aba");
        System.out.println("b = " + b);
    }

}
