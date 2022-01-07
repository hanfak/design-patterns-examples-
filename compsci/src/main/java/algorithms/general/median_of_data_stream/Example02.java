package algorithms.general.median_of_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example02 {
    public static void main(String... args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        double median = medianFinder.findMedian();
        System.out.println("median = " + median);
    }
}

class MedianFinder2 {
    PriorityQueue<Integer> minHeap = null;
    PriorityQueue<Integer> maxHeap = null;

    /** initialize your data structure here. */
    public MedianFinder2() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if(minHeap.size()<maxHeap.size()){
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
    }
}