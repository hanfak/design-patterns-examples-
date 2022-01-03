package algorithms.sorting.quicksort.example03;

import static algorithms.sorting.Util.*;

// Using median of 3 to get pivot, and do a pre sort array
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

    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }
        // Pivot using median of 3 approach
        int pivot = getMedian(array, lowIndex, highIndex);
        int index = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, index - 1);
        quicksort(array, index + 1, highIndex);
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

    //  We used the first, the middle, and last items of the array to find the median. The median is the middle item between the orderly placed items. This approach is not only used to select the pivot but also to put the three items in their sorted place in the array.
    // The returned median is used as the pivot in quicksort. This method has two parameters, both pointing at each end of the array or the sub-array. We used the middle, left and right items to find the median. In the end, we swapped the median with the item at the rightmost position of the array. So, after the scan, all these three items should be in their proper sorted places in the array. This process is repeated with all the sub-arrays having different left, right and middle positions until the full array gets sorted.
    //This "median-of-three" rule counters the case of sorted (or reverse-sorted) input, and gives a better estimate of the optimal pivot (the true median) than selecting any single element, when no information about the ordering of the input is known.
    public static int getMedian(int[] array, int left, int right) {
        int center = (left + right) / 2;

        if (array[left] > array[center]) {
            swap(array, left, center);
        }

        if (array[left] > array[right]) {
            swap(array, left, right);
        }

        if (array[center] > array[right]) {
            swap(array, center, right);
        }

        swap(array, center, right);
        return array[right];
    }

    private static void swap(int[] array, int lowIndex, int highIndex) {
        int temp = array[lowIndex];
        array[lowIndex] = array[highIndex];
        array[highIndex] = temp;
    }
}
