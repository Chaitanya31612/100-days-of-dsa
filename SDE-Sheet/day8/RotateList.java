package day8;

import day6.ListNode;

//https://leetcode.com/problems/rotate-list/discuss/1547464/Java-easy-solution-oror-100-faster
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode tail = head;
        // find the count and let tail points to last node
        int count = 1;
        while(tail != null && tail.next != null) {
            count++;
            tail = tail.next;
        }

        // calculate number of times to rotate by count modulas
        int K = k % count;
        // if K=0 then return original
        if(K == 0) return head;
        ListNode temp = head;
        // iterate and go to the K+1 th node from the end or  count - K - 1 node from start
        for(int i = 1; i <= count - K - 1 && temp != null; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        tail.next = head;

        return newHead;
    }
}
