package other.sorting.bubblesort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleSortTest {

  @Test
  public void givenIntegerArray_whenSortedWithBubbleSort_thenGetSortedArray() {
    Integer[] array = { 12, 11, 14, 16, 13, 15 };
    Integer[] sortedArray = { 11, 12, 13, 14, 15, 16 };
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.bubbleSort(array);
    assertArrayEquals(array, sortedArray);
  }

  @Test
  public void givenIntegerArray_whenSortedWithOptimizedBubbleSort_thenGetSortedArray() {
    Integer[] array = { 2, 1, 4, 6, 3, 5 };
    Integer[] sortedArray = { 1, 2, 3, 4, 5, 6 };
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.optimizedBubbleSort(array);
    assertArrayEquals(array, sortedArray);
  }
}