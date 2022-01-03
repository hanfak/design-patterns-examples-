package algorithms.sorting.parallelquicksort.example01;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static algorithms.sorting.Util.*;
// Much faster than synchronous version for larger arrays
public class Runner {
    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(10);

        System.out.println("Before:");
        printArray(randomNumbers);

        Runnable runnable = () -> parallelQuickSort(randomNumbers);
        measureTimeOfExecution(runnable);
        System.out.println("after:");
        printArray(randomNumbers);
    }

    private static void parallelQuickSort(int[] array) {
        SortTask mainTask = new SortTask(array, 0 , array.length - 1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {

        private final int[] array;
        private final int start;
        private final int end;

        public SortTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start >= end) {
                return;
            }

            int pivotIndex = new Random().nextInt(end - start) + start;

            int pivot = array[pivotIndex];
            swap(array, pivotIndex, end);
            int leftPointer = partition(array, start, end, pivot);

            SortTask sortTaskFirst = new SortTask(array, start, leftPointer - 1);
            SortTask sortTaskSecond = new SortTask(array, leftPointer + 1, end);
            invokeAll(sortTaskFirst, sortTaskSecond);
        }
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

            swap(array, leftPointer, rightPointer); // swap the two elements
        }
        swap(array, leftPointer, highIndex); // swap the pivot with element where the two pointers meet
        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
