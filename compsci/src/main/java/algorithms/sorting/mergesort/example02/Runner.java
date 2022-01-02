package algorithms.sorting.mergesort.example02;

import static algorithms.sorting.Util.*;

public class Runner {

    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(10);

//        System.out.println("Before:");
//        printArray(randomNumbers);

        Runnable runnable = () -> mergeSort(randomNumbers);
        measureTimeOfExecution(runnable);
        System.out.println("after:");
        printArray(randomNumbers);
    }

    static void mergeSort(int[] numbers) {
        mergeSort(numbers, new int[numbers.length], 0, numbers.length - 1);
    }

    private static void mergeSort(int[] numbers, int[] temp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return;
        int midpoint = (leftStart + rightEnd) / 2;
        mergeSort(numbers, temp, leftStart, midpoint);
        mergeSort(numbers, temp, midpoint + 1, rightEnd);
        merge(numbers, temp, leftStart, rightEnd);
    }

    private static void merge(int[] numbers, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;

        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (numbers[left] <= numbers[right]) {
                temp[index] = numbers[left];
                left++;
            } else {
                temp[index] = numbers[right];
                right++;
            }
            index++;
        }
        System.arraycopy(numbers, left, temp,index, leftEnd - left + 1);
        System.arraycopy(numbers, right, temp,index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, numbers,leftStart,size);
    }
}
