package algorithms.hashtable.ransomnote;

import java.util.HashMap;
import java.util.Map;

public class _02Example {// TODO:  complete
    static Map<Character, Integer> characterCountMap = new HashMap<>();
    static {
        characterCountMap.put('a',0);
        characterCountMap.put('b',0);
        characterCountMap.put('c',0);
        characterCountMap.put('d',0);
        characterCountMap.put('e',0);
        characterCountMap.put('f',0);
        characterCountMap.put('g',0);
        characterCountMap.put('h',0);
        characterCountMap.put('i',0);
        characterCountMap.put('j',0);
        characterCountMap.put('k',0);
        characterCountMap.put('l',0);
        characterCountMap.put('m',0);
        characterCountMap.put('n',0);
        characterCountMap.put('o',0);
        characterCountMap.put('p',0);
        characterCountMap.put('q',0);
        characterCountMap.put('r',0);
        characterCountMap.put('s',0);
        characterCountMap.put('t',0);
        characterCountMap.put('u',0);
        characterCountMap.put('v',0);
        characterCountMap.put('w',0);
        characterCountMap.put('x',0);
        characterCountMap.put('y',0);
        characterCountMap.put('z',0);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() == 1 && magazine.length() == 1) return ransomNote.equals(magazine);
        // could preconstruct with all letters of alphabet

//        Map<Character, Integer> characterCountMap = new HashMap<>();
        for (char letter : magazine.toCharArray()) {
            characterCountMap.put(letter, characterCountMap.getOrDefault(letter, 0) + 1);
        }
        for (char letter: ransomNote.toCharArray()) {
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
