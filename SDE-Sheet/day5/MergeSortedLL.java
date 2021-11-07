package day5;

public class MergeSortedLL {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode p1 = l1, p2 = l2, p3 = l3;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                ListNode newNode = new ListNode(p1.val);
                if(l3 == null) {
                    l3 = newNode;
                } else {
                    p3.next = newNode;
                }
                p3 = newNode;
                p1 = p1.next;
            } else {
                ListNode newNode = new ListNode(p2.val);
                if(l3 == null) {
                    l3 = newNode;
                } else {
                    p3.next = newNode;
                }
                p3 = newNode;
                p2 = p2.next;
            }
        }

        while(p1 != null) {
            ListNode newNode = new ListNode(p1.val);
            if(l3 == null) {
                l3 = newNode;
            } else {
                p3.next = newNode;
            }
            p3 = newNode;
            p1 = p1.next;
        }

        while(p2 != null) {
            ListNode newNode = new ListNode(p2.val);
            if(l3 == null) {
                l3 = newNode;
            } else {
                p3.next = newNode;
            }
            p3 = newNode;
            p2 = p2.next;
        }

        return l3;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode l1 = l.takeInput();
        ListNode l2 = l.takeInput();

        MergeSortedLL ml = new MergeSortedLL();
        ListNode l3 = ml.mergeTwoLists(l1, l2);
        l.print(l3);
    }
}
