package algorithms.sorting.quicksort.example01;

import java.util.Random;

import static algorithms.sorting.Util.*;

public class Runner {
    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(100_000_000);

//        System.out.println("Before:");
//        printArray(randomNumbers);

        Runnable runnable = () -> quicksort(randomNumbers);
        measureTimeOfExecution(runnable);
//        System.out.println("after:");
//        printArray(randomNumbers);
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        // Choose pivot index at random, improve performance on average
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
//        int pivotIndex = lowIndex + (highIndex - lowIndex)/2; // Can choose the mid point, done this way to avoid integer overflow
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex); // place pivot index at the end

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
