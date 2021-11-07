package day7;

import java.util.HashMap;

// https://leetcode.com/problems/copy-list-with-random-pointer/discuss/1554903/Java-easy-solution-100-oror-HashMap-and-optimised-approach
public class CopyLL {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomListOptimised(Node head) {
        if(head == null) return null;
        // Make a temp pointer pointing to head
        Node temp = head;
        // traverse and add the newNode (copy of current node) to the right of each node
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // reinitiallize temp pointer to head
        temp = head;
        // Traverse through the modified linked list and make the next pointer of the next node
        // which is our copy node and set it's random pointer to the next node to temp.random
        // which is also part of our copy node.
        while(temp != null) {
            if(temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        Node newHead = new Node(0), curr = newHead;
        temp = head;
        // Now this type traverse and copy the duplicate nodes into a new list with head as newHead.
        while(temp != null) {
            Node tempNode = temp.next;
            temp.next = temp.next.next;
            curr.next = tempNode;
            curr = curr.next;
            temp = temp.next;
        }

        // return the next node as newHead points to 0
        return newHead.next;
    }

    public Node copyRandomList(Node head) {
        if(head == null) return head;
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node curr = newHead, temp = head;
        map.put(null, null);

        // iterate and put original as well as its corresponding copy node in map
        while(temp != null) {
            curr.next = new Node(temp.val);
            curr = curr.next;
            map.put(temp, curr);
            temp = temp.next;
        }

        temp = head;
        curr = newHead.next;
        // then iterate again and make the random pointer of duplicate nodes point to map.get(temp.random) which stores corresponding random node in the map.
        while(temp != null && curr != null) {
            curr.random = map.get(temp.random);
            curr = curr.next;
            temp = temp.next;
        }

        return newHead.next;
    }

}
