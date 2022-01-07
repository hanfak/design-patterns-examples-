package algorithms.general.median_of_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example03 {

    public static void main(String... args) {
        MedianFinder3 medianFinder = new MedianFinder3();
//        medianFinder.addNum(3);
        medianFinder.addNum(2);
//        medianFinder.addNum(3);

        double median = medianFinder.findMedian();
        System.out.println("median = " + median);
    }
}

class MedianFinder3 {

    PriorityQueue<Integer> largerHeap = new PriorityQueue<>();
    PriorityQueue<Integer> smallHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        smallHeap.offer(num);

        if (smallHeap.size() > 0 && largerHeap.size() > 0 && smallHeap.peek() > largerHeap.peek()) {
            Integer largestItemInSmallHeap = smallHeap.poll();
            largerHeap.offer(largestItemInSmallHeap);
        }

        if (smallHeap.size() > largerHeap.size() + 1) {
            Integer largestItemInSmallHeap = smallHeap.poll();
            largerHeap.offer(largestItemInSmallHeap);
        }

        if (largerHeap.size() > smallHeap.size() + 1) {
            Integer smallestItemInLargerHeap = largerHeap.poll();
            smallHeap.offer(smallestItemInLargerHeap);
        }
    }

    public double findMedian() {
        if (smallHeap.size() > largerHeap.size()) {
            return smallHeap.peek();
        }
        if (largerHeap.size() > smallHeap.size()) {
            return largerHeap.peek();
        }
        return (smallHeap.peek() + largerHeap.peek()) / 2.0;
    }
}