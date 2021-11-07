package day5;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/discuss/1540230/java-easy-solution-with-explanation-100-faster-0ms-brute-force-and-optimized-approach
public class RemoveNth {
    public ListNode removeNthFromEndBrute(ListNode head, int n) {
        ListNode temp = head;
        int c = 0;
        while(temp != null) {
            c++;
            temp = temp.next;
        }
        int t = c - n;
        if(t == 0) {
            head = head.next;
            return head;
        }
        temp = head;
        while(t-- > 1) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode slow = head, fast = head;

        for(int i = 1; i <= n; i++)
            fast = fast.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head && fast == null) {
            head = head.next;
            return head;
        }

        if(slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.takeInput();

        RemoveNth rn = new RemoveNth();
        head = rn.removeNthFromEndBrute(head, 2);
        l.print(head);
    }
}
