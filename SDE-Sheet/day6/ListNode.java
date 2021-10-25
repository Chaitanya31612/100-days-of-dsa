package day6;

import java.util.Scanner;

public class ListNode {
 int val;
 ListNode next;
 ListNode() {}
 ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }

 public ListNode takeInput() {
  Scanner sc = new Scanner(System.in);
  int data = sc.nextInt();
  if(data == -1)
   return null;

  ListNode head = null, curr = head;
  while(data != -1) {
   ListNode newNode = new ListNode(data);
   if(head == null) {
    head = newNode;
   } else {
    curr.next = newNode;
   }
   curr = newNode;
   data = sc.nextInt();
  }

  return head;
 }

 public void print(ListNode head) {
  ListNode temp = head;
  while(temp != null) {
   System.out.print(temp.val + " ");
   temp = temp.next;
  }
  System.out.println();
 }
}