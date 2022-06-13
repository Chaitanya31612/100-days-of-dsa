package day6_ll;

import day5_ll.ListNode;

import java.util.ArrayList;
import java.util.Stack;
//https://leetcode.com/problems/palindrome-linked-list/discuss/1542014/Java-easy-solution-oror-ArrayList-Stack-Reverse-list-method
public class PalindromeList {
    public boolean isPalindromeBrute(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp= head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        for(int i =0; i < list.size() / 2;i++) {
            if(list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;

        ListNode temp = head;
        int c = 0;
        while(temp != null) {
            c++;
            temp = temp.next;
        }

        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if((c&1) == 1) {
            stack.push(slow.val);
        }

        while(!stack.isEmpty()) {
            int v = stack.pop();
            if(v != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public boolean isPalindromeReverse(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        // make the slow pointer points to middle element
        // this is used to keep the slow to the left element in case of even length list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list on the right of slow
        ReverseLLIterative r = new ReverseLLIterative();
        slow.next = r.reverseLLIterative(slow.next);

        // increment the slow pointer by one
        slow = slow.next;

        while(slow != null) {
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode();
        ListNode head = l.takeInput();

        PalindromeList pl = new PalindromeList();
        System.out.println(pl.isPalindrome(head));
    }
}
