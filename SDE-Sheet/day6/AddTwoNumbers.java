package day6;

// https://leetcode.com/problems/add-two-numbers/discuss/1540260/Java-easy-intuitive-solution

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode temp = l3;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            if(sum > 9) {
                carry = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            temp = newNode;
        }
        while(l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            if(sum > 9) {
                carry = 1;
            }
            l1 = l1.next;
            temp = newNode;
        }
        while(l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            if(sum > 9) {
                carry = 1;
            }
            l2 = l2.next;
            temp = newNode;
        }

        if(carry == 1) {
            temp.next = new ListNode(1);
        }

        return l3.next;
    }

    public ListNode addTwoNumbersLC(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
