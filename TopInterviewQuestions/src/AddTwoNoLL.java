public class AddTwoNoLL {
    static int carry = 0;
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1, temp2 = l2;
        ListNode temp3 = null, curr = temp3;
        while(temp1 != null && temp2 != null) {
            ListNode node = new ListNode((temp1.val + temp2.val + carry) % 10);
            carry = (temp1.val + temp2.val + carry) / 10;
            if(temp3 == null) {
                temp3 = node;
            } else {
                curr.next = node;
            }
            curr = node;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1 != null) {
            ListNode node = new ListNode((temp1.val + carry) % 10);
            carry = (temp1.val + carry) / 10;
            if(temp3 == null)
                temp3 = node;
            else
                curr.next = node;
            curr = node;
            temp1 = temp1.next;
        }

        while(temp2 != null) {
            ListNode node = new ListNode((temp2.val + carry) % 10);
            carry = (temp2.val + carry) / 10;
            if(temp3 == null)
                temp3 = node;
            else
                curr.next = node;
            curr = node;
            temp2 = temp2.next;
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry);
            if(temp3 == null)
                temp3 = node;
            else
                curr.next = node;
            curr = node;
        }

        return temp3;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();

        ListNode l1 = l.input();
        ListNode l2 = l.input();
        ListNode l3 = addTwoNumbers(l1, l2);
        l.print(l3);
    }
}
