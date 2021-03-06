package day22_binarytreemisc;

import java.util.PriorityQueue;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums) {
            heap.offer(num);
        }

        while(heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}
