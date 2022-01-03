package algorithms.sorting.quicksort.example04;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    public void apply(T[] array) {
        apply(array, 0, array.length - 1);

    }

    private void apply(T[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;

        T pivot = array[pivotIndex];

        swap(array, pivotIndex, highIndex);

        int partition = partition(array, lowIndex, highIndex, pivot);

        apply(array, lowIndex, partition - 1);
        apply(array, partition + 1, highIndex);
    }

    private int partition(T[] array, int lowIndex, int highIndex, T pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer < rightPointer) {

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer
//            Comparator<Employee> byRanking = Comparator.comparingInt(Employee::getEmplyeeCode);
//            while (byRanking.compare((Employee) array[leftPointer], (Employee) pivot) <= 0 && leftPointer < rightPointer) {
            while (array[leftPointer].compareTo(pivot) <= 0 && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
//            while (byRanking.compare((Employee) array[rightPointer], (Employee) pivot) >= 0 && leftPointer < rightPointer) {
            while (array[rightPointer].compareTo(pivot) >= 0 && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

}
