package day6_ll;

import day5_ll.ListNode;

// https://leetcode.com/problems/linked-list-cycle-ii/discuss/1547406/Java-easy-solution-oror-100-faster-oror-O(n)-time-O(1)-space
public class LinkedCycle2 {
    // this approach is best but it is modifying the linked list and that may not be acceptable
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            if(temp.val == Integer.MAX_VALUE)
                return temp;
            temp.val = Integer.MAX_VALUE;
            temp = temp.next;
        }

        return null;
    }

    public ListNode detectCycleOpt(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                fast = head;
                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }

        }

        return null;
    }

    public static void main(String[] args) {

    }
}
