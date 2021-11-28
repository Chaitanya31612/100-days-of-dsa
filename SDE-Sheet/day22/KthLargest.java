package day22;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> heap;
    private static int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for(int num: nums) {
            heap.offer(num);
        }

        while(heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        while(heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
