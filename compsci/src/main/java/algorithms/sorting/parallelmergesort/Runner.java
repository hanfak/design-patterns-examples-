package algorithms.sorting.parallelmergesort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static algorithms.sorting.Util.*;
import static algorithms.sorting.mergesort.example03.Runner.merge;

public class Runner {

    public static void main(String... args) {
        int[] randomNumbers = randomNumbers(100_000_000);

//        System.out.println("Before:");
//        printArray(randomNumbers);

        Runnable runnable = () -> parallelMergeSort(randomNumbers);
        measureTimeOfExecution(runnable);
//        System.out.println("after:");
//        printArray(randomNumbers);
    }

    public static void parallelMergeSort(int[] array) {
        SortTask mainTask = new SortTask(array);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {

        private int[] array;

        public SortTask(int[] array) {
            this.array = array;
        }

        @Override
        protected void compute() {
            if (array.length > 1) {
                int mid = array.length / 2;

                // Obtain the first half
                int[] firstHalf = new int[mid];
                System.arraycopy(array, 0, firstHalf, 0, mid);

                // Obtain the second half
                int[] secondHalf = new int[array.length - mid];
                System.arraycopy(array, mid, secondHalf, 0, array.length - mid);

                // Recursively sort the two halves
                SortTask firstHalfTask = new SortTask(firstHalf);
                SortTask secondHalfTask = new SortTask(secondHalf);
                // Invoke declared tasks
                invokeAll(firstHalfTask, secondHalfTask);

                //Merge firstHalf with secondHalf into our array
                merge(firstHalf, secondHalf, array);
            }
        }
    }
}
