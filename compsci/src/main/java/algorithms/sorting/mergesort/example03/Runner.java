package algorithms.sorting.mergesort.example03;

import static algorithms.sorting.Util.*;

public class Runner {

    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(100_000_000);

//        System.out.println("Before:");
//        printArray(randomNumbers);

        Runnable runnable = () -> mergeSort(randomNumbers);
        measureTimeOfExecution(runnable);
//        System.out.println("after:");
//        printArray(randomNumbers);
    }

    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Obtain the first half
            int mid = array.length / 2;
            int[] firstHalf = new int[mid];
            System.arraycopy(array, 0, firstHalf, 0, mid);

            // Obtain the second half
            int[] secondHalf = new int[array.length - mid];
            System.arraycopy(array, mid, secondHalf, 0, array.length - mid);

            // Recursively sort the two halves
            mergeSort(firstHalf);
            mergeSort(secondHalf);

            //Merge firstHalf with secondHalf into our array
            merge(firstHalf, secondHalf, array);
        }
    }

    public static void merge(int[] firstHalf, int[] secondHalf, int[] array) {
        int currentIndexFirst = 0;
        int currentIndexSecond = 0;
        int currentIndexArray = 0;

        while (currentIndexFirst < firstHalf.length && currentIndexSecond < secondHalf.length) {
            if (firstHalf[currentIndexFirst] < secondHalf[currentIndexSecond]) {
                array[currentIndexArray] = firstHalf[currentIndexFirst];
                currentIndexFirst++;
            } else {
                array[currentIndexArray] = secondHalf[currentIndexSecond];
                currentIndexSecond++;
            }
            currentIndexArray++;
        }

        while (currentIndexFirst < firstHalf.length) {
            array[currentIndexArray] = firstHalf[currentIndexFirst];
            currentIndexArray++;
            currentIndexFirst++;
        }

        while (currentIndexSecond < secondHalf.length) {
            array[currentIndexArray] = secondHalf[currentIndexSecond];
            currentIndexArray++;
            currentIndexSecond++;
        }
    }
}
