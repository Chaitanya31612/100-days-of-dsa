package day6;

import day5.ListNode;

import java.util.HashSet;

public class DetectCycle {
    public boolean hasCycleBrute(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = head;
        while(temp != null) {
            if(set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }

        return false;
    }

    // 0ms
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            if(slow == fast)
                return true;
            slow = slow.next;
        }
        return false;
    }
}
