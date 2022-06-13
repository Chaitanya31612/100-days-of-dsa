package day6_ll;

import day5_ll.ListNode;

import java.util.HashSet;

//https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/1541753/Java-easy-solution-with-explanation-oror-All-approaches
public class IntersectionOfLL {
    // the very first brute force approach is to start from and traverse the second list and return if they are equal, this is O(m*n) approach with O(1) space complexity


    // time O(n) space O(size of list A)
    // time on leetcode 7ms
    public ListNode getIntersectionNodeBrute(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = headA;
        // add all the elements of list a in set
        while(temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        // check if the nodes in list B is present in set
        while(temp != null) {
            if(set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Optimal 1
    // first calculate count of both nodes
    // then move the longer list by the difference
    // then return if you find them to be same

    // time on leetcode - 1ms
    public static ListNode getIntersectionNodeO1(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int c1 = 0, c2 = 0;
        ListNode temp1 = headA, temp2 = headB;
        // count the length of list A and list B
        while(temp1 != null) {
            c1++;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            c2++;
            temp2 = temp2.next;
        }

        temp1 = headA; temp2 = headB;

        // move the longer list by |c1-c2| steps
        for(int i = 1; i <= (Math.abs(c1 - c2)); i++) {
            if(c1 > c2) {
                temp1 = temp1.next;
            } else {
                temp2 = temp2.next;
            }
        }

        // now again move both the pointer till the end, and they both will travel same number of steps now
        while(temp1 != null && temp2 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return null;
    }

    // Optimal 2
    public ListNode getIntersectionNodeO2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode temp1 = headA, temp2 = headB;

        while(temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null) {
            temp1 = headB;
        } else {
            temp2 = headA;
        }

        while(temp1 != null && temp2 != null) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if(temp1 == null) {
            temp1 = headB;
        } else {
            temp2 = headA;
        }

        while(temp1 != null && temp2 != null) {
            if(temp1 == temp2) {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    // optimal 2 shorter
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode temp1 = headA, temp2 = headB;
        while(temp1 != temp2) {
            temp1 = temp1 == null ? headB : temp1.next;
            temp2 = temp2 == null ? headA : temp2.next;
        }

        return temp1;
    }

    public static void main(String[] args) {

    }
}
