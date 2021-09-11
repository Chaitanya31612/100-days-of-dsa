public class RemoveNth {
    public static ListNode removeNthFromEndNaive(ListNode head, int n) {
        ListNode temp = head;

        int length = 0;
        while(temp != null) {
            length++;
            temp = temp.next;
        }

        int moves = length - n, i = 0;
        if(moves == 0) {
            head = head.next;
            return head;
        }

        System.out.println(length + " " + moves);
        temp = head;
        while(temp != null && ++i < moves) {
            temp = temp.next;
        }

        if(temp != null && temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        // first move fast pointer by n steps to maintain the gap
        for(int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        // now move slow and fast pointer until fast pointer gets to null
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == head && fast == null) {
            head = head.next;
            return head;
        }
        if(slow != null && slow.next != null)
            slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head = head.takeInput();

        head = removeNthFromEnd(head, 1);
//        head = removeNthFromEndNaive(head, 1);
        head.print(head);

    }
}
