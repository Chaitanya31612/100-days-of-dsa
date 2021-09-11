import java.util.Scanner;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode takeInput() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for(int i = 1; i <= n - 1; i++) {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        return head;
    }

    public void print(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}