package algorithms.sorting.quicksort.example02;

import static algorithms.sorting.Util.*;
import static algorithms.sorting.Util.printArray;
// last element as pivot
public class Runner {

    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(10);

        System.out.println("Before:");
        printArray(randomNumbers);

        Runnable runnable = () -> quicksort(randomNumbers);
        measureTimeOfExecution(runnable);
        System.out.println("after:");
        printArray(randomNumbers);
    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int left, int right) {

        // If both cursor scanned the complete array quicksort exits
        if (left >= right) {
            return;
        }

        int pivot = array[right]; // last element
        int partition = partition(array, left, right, pivot);

        quicksort(array, left, partition - 1);
        quicksort(array, partition + 1, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        int leftCursor = left - 1;
        int rightCursor = right;

        while (leftCursor < rightCursor) {
            while (array[++leftCursor] < pivot) ;
            // Same as
            // while( array[leftCursor] <pivot) {leftCursor++;}
            while (rightCursor > 0 && array[--rightCursor] > pivot) ;
            if (leftCursor >= rightCursor) {
                break;
            } else {
                swap(array, leftCursor, rightCursor);
            }
        }
        swap(array, leftCursor, right);
        return leftCursor;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
