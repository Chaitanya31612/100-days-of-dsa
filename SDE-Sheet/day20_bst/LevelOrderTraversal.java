package day20_bst;

import day17_binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void levelOrder(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                System.out.print(front.val + "->");
                if(queue.peek() != null)
                System.out.println(" peek "+ queue.peek().val);
                else System.out.println("null");
                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1; root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left = node3; node1.right = node4;
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node2.left = node5; node2.right = node6;

        levelOrder(root);
    }
}
