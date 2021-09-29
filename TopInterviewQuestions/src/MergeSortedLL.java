public class MergeSortedLL {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode i = l1, j = l2;
        ListNode l3 = null;
        ListNode curr = l3;
        while(i != null && j != null) {
            int val;
            if(i.val <= j.val) {
                val = i.val;
                i = i.next;
            } else {
                val = j.val;
                j = j.next;
            }
            ListNode newNode = new ListNode(val);
            if(l3 == null) {
                l3 = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
        }

        while(i != null) {
            ListNode newNode = new ListNode(i.val);
            if(l3 == null) {
                l3 = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
            i = i.next;
        }

        while(j != null) {
            ListNode newNode = new ListNode(j.val);
            if(l3 == null) {
                l3 = newNode;
            } else {
                curr.next = newNode;
            }
            curr = newNode;
            j = j.next;
        }

        return l3;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode l1 = l.input();
        ListNode l2 = l.input();
        ListNode l3 = mergeTwoLists(l1, l2);
        l.print(l3);
    }
}
