package day5;

import java.util.Scanner;

public class ListNode {
 public int val;
 public ListNode next;
 public ListNode() {}
 public ListNode(int val) { this.val = val; }
 public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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