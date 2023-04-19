package stack_heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @ClassName FindMedianfromDataStream
 * @Description TODO
 * @Author katefu
 * @Date 4/19/23 5:55 PM
 * @Version 1.0
 **/
public class FindMedianfromDataStream {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(2);
        mf.addNum(3);
        mf.addNum(1);
        mf.findMedian();
    }
}


class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}