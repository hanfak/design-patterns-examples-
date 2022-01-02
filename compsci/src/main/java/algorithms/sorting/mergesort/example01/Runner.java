package algorithms.sorting.mergesort.example01;

import static algorithms.sorting.Util.measureTimeOfExecution;
import static algorithms.sorting.Util.randomNumbers;

public class Runner {

    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(10);

//        System.out.println("Before:");
//        printArray(randomNumbers);

        Runnable runnable = () -> mergeSort(randomNumbers);
        measureTimeOfExecution(runnable);
//        System.out.println("after:");
//        printArray(randomNumbers);
    }

    private static void mergeSort(int[] numbers) {
        int amountOfNumbers = numbers.length;

        if (amountOfNumbers < 2) { // Return numbers cannot be split
            return;
        }

        int midPositionOfNumbers = amountOfNumbers / 2;
        int[] firstHalfOfNumbers = new int[midPositionOfNumbers];
        int[] lastHalfOfNumbers = new int[amountOfNumbers - midPositionOfNumbers];

        for (int i = 0; i < midPositionOfNumbers; i++) {
            firstHalfOfNumbers[i] = numbers[i];
        }
        for (int i = midPositionOfNumbers; i < amountOfNumbers; i++) {
            lastHalfOfNumbers[i - midPositionOfNumbers] = numbers[i];
        }
//        System.arraycopy(numbers, 0, firstHalfOfNumbers, 0, midPositionOfNumbers);
//        if (amountOfNumbers - midPositionOfNumbers >= 0)
//            System.arraycopy(numbers, midPositionOfNumbers, lastHalfOfNumbers, 0, amountOfNumbers - midPositionOfNumbers);

        mergeSort(firstHalfOfNumbers);
        mergeSort(lastHalfOfNumbers);

        merge(numbers, firstHalfOfNumbers, lastHalfOfNumbers);
    }

    private static void merge(int[] numbers, int[] firstHalfOfNumbers, int[] lastHalfOfNumbers) {
        int lengthOfFirstHalf = firstHalfOfNumbers.length;
        int lengthOfLastHalf = lastHalfOfNumbers.length;

        int indexInFirstHalf = 0;
        int indexInLastHalf = 0;
        int indexInNumbers = 0;

        while (indexInFirstHalf < lengthOfFirstHalf && indexInLastHalf < lengthOfLastHalf) {
            if (firstHalfOfNumbers[indexInFirstHalf] <= lastHalfOfNumbers[indexInLastHalf]) {
                numbers[indexInNumbers] = firstHalfOfNumbers[indexInFirstHalf];
                indexInFirstHalf++;
            } else {
                numbers[indexInNumbers] = lastHalfOfNumbers[indexInLastHalf];
                indexInLastHalf++;
            }
            indexInNumbers++;
        }

        while (indexInFirstHalf < lengthOfFirstHalf) {
            numbers[indexInNumbers] = firstHalfOfNumbers[indexInFirstHalf];
            indexInFirstHalf++;
            indexInNumbers++;
        }

        while (indexInLastHalf < lengthOfLastHalf) {
            numbers[indexInNumbers] = lastHalfOfNumbers[indexInLastHalf];
            indexInLastHalf++;
            indexInNumbers++;
        }

    }
}