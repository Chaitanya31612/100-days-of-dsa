package day6;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode reversedTail = head.next;
        ListNode newHead = reverseList(head.next);
        reversedTail.next = head;
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.takeInput();

        ReverseLL rl = new ReverseLL();
        head = rl.reverseList(head);
        l.print(head);
    }
}
