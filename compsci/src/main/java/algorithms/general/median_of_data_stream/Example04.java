package algorithms.general.median_of_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Example04 {

    public static void main(String... args) {
        MedianFinder4 medianFinder = new MedianFinder4();
        medianFinder.addNum(3);
        medianFinder.addNum(1);
        medianFinder.addNum(2);

        double median = medianFinder.findMedian();
        System.out.println("median = " + median);
    }
}

class MedianFinder4 {

    PriorityQueue<Integer> large = new PriorityQueue<>();
    PriorityQueue<Integer> small = new PriorityQueue<>(Comparator.reverseOrder());

    public void addNum(int num) {
        if (small.isEmpty() && large.isEmpty()) {
            small.add(num);
            return;
        }

        if (small.size() > large.size()) {
            if (small.peek() < num) {
                large.add(num);
            } else {
                large.add(small.poll());
                small.add(num);
            }
        } else {
            if (large.peek() > num) {
                small.add(num);
            } else {
                small.add(large.poll());
                large.add(num);
            }
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        }
        return small.peek();
    }
}