import java.util.List;
import java.util.Scanner;

public class MiddleLL {

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = head.takeInput();

        ListNode ans = middleNode(head);
        System.out.println(ans.val);
    }
}
