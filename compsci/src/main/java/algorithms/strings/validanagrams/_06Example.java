package algorithms.strings.validanagrams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06Example {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return hashed(s) == hashed(t);
    }
    private static final int[] PRIMES = new int[]{3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
            73, 79, 83, 89, 97, 101, 107};

    private static long hashed(String s) {

        long hash = 1;
        for (int i = 0; i < s.length(); i++) {
            hash *= PRIMES[s.charAt(i) - 'a']; // as a ==32, and all letters lowercase then will set the value from 0 so match prime list
        }
        return hash;
    }

    // Can use this to create set of primes, esp if hardcoded is hard to write, for words that have non latin letters
    public static List<Integer> firstNPrimeNumbers(int num) {
        return IntStream.range(2, Integer.MAX_VALUE)
                .filter(n -> isPrime(n))
                .limit(num)    //Limit the number of primes here
                .boxed()
                .collect(Collectors.toList());
    }

    static boolean isPrime(int number) {
        if(number <= 2)
            return number == 2;
        else
            return  (number % 2) != 0
                    &&
                    IntStream.rangeClosed(3, (int) Math.sqrt(number))
                            .filter(n -> n % 2 != 0)
                            .noneMatch(n -> (number % n == 0));
    }

    public static void main(String... args) {
        boolean anagram = isAnagram("nl", "cx");
        System.out.println("anagram = " + anagram);

    }
}
