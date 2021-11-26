package day17;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode takeInput() {
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode> pendingNodes = new LinkedList<>();
        int data = sc.nextInt();
        if(data == -1) return null;
        TreeNode root = new TreeNode(data);
        pendingNodes.add(root);

        while(!pendingNodes.isEmpty()) {
            TreeNode front = pendingNodes.poll();

            int leftData = sc.nextInt();
            if(leftData != -1) {
                TreeNode leftNode = new TreeNode(leftData);
                front.left = leftNode;
                pendingNodes.add(leftNode);
            }

            int rightData = sc.nextInt();
            if(rightData != -1) {
                TreeNode rightNode = new TreeNode(rightData);
                front.right = rightNode;
                pendingNodes.add(rightNode);
            }
        }

        return root;
    }
}
