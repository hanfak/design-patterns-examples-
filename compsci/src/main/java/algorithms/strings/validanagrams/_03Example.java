package algorithms.strings.validanagrams;

import java.util.Arrays;

public class _03Example {
    // Same as example2
    // exit fast
    public static boolean isAnagram(String s, String t) {
        if ( s.length() != t.length() ) return false;
        char[] tempArray1 = s.toCharArray();
        char[] tempArray2 = t.toCharArray();
        Arrays.sort(tempArray1);
        Arrays.sort(tempArray2);
        for(int i=0; i<tempArray1.length; i++){
            if(tempArray1[i] != tempArray2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String... args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println("anagram = " + anagram);
    }
}
