package day6_ll;

import day5_ll.ListNode;

public class ReverseLLIterative {
    public ListNode reverseLLIterative(ListNode head) {
        ListNode pre = null, next = null, curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

    public static void main(String[] args) {

    }
}
