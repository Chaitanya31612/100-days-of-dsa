package day20;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class PopulateNextPointer {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            Queue<Node> temp = new LinkedList<>(queue);
            for(int i = 1; i <= size; i++) {
                Node front = temp.poll();
                front.next = temp.peek();
            }
            for(int i = 1; i <= size; i++) {
                Node front = queue.poll();

                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            }
        }

        return root;
    }
}
