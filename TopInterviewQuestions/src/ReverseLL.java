public class ReverseLL {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode reversedTail = head.next;
        ListNode newHeadNode = reverseList(head.next);
        reversedTail.next = head;
        head.next = null;

        return newHeadNode;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.input();
        l.print(head);
        head = reverseList(head);
        l.print(head);
    }
}
