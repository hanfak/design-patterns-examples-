package algorithms.general.median_of_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example01 {

    public static void main(String... args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        double median = medianFinder.findMedian();
        System.out.println("median = " + median);
    }
}
// * The insertion/update of the data would then have the complexity of O(nlgn)
// *  while we would have a constant O(1) complexity for the median calculation
class MedianFinder {


    private static final Integer INIT_CAPACITY = 10000;

    //! Maintain the first half list in the descending order, so that
    //   we could benefit from the O(nlgn) operators peek() and poll().
    private PriorityQueue<Integer> firstHalf =
            new PriorityQueue<Integer>(INIT_CAPACITY, Comparator.reverseOrder());

    //! Use the default (ascending) order for the second half list.
    private PriorityQueue<Integer> secondHalf =
            new PriorityQueue<Integer>(INIT_CAPACITY);

    private double median = Double.MAX_VALUE;

    /**
     *  Attribute the incoming data and update the median.
     * @param num
     */
    public void addNum(int num) {
        if(num < median) {
            firstHalf.add(num);
        } else {
            secondHalf.add(num);
        }

        updateMedian();
    }

    /**
     *  Balance the two halves to keep the constrain that
     *    | size(firstHalf) - size(secondHalf) | <= 1
     */
    private void updateMedian() {
        int firstHalfSize = firstHalf.size();
        int secondHalfSize = secondHalf.size();

        // The lists are balanced.
        if(firstHalfSize == secondHalfSize) {
            median = (firstHalf.peek() + secondHalf.peek())/2.0;

        } else if(firstHalfSize > secondHalfSize) {
            // The lists are still balanced.
            if(firstHalfSize - secondHalfSize == 1) {
                median = firstHalf.peek();
            } else {
                // re-balancing by moving last element from the first half to second.
                int last_firstHalf = firstHalf.poll();
                secondHalf.offer(last_firstHalf);
                // recursively rebalancing the lists.
                // The recursion would not exceeds twice though.
                updateMedian();
            }
        } else {
            // firstHalfSize < secondHalfSize
            if(secondHalfSize - firstHalfSize == 1) {
                median = secondHalf.peek();
            } else {
                int first_secondHalf = secondHalf.poll();
                firstHalf.offer(first_secondHalf);
                updateMedian();
            }
        }
    }

    public double findMedian() {
        return median;
    }
}