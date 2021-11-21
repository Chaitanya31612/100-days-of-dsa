package day18;

import day17.TreeNode;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int op1 = height(root.left) + height(root.right);
        int op2 = diameterOfBinaryTree(root.left);
        int op3 = diameterOfBinaryTree(root.right);

        return Math.max(op1, Math.max(op2, op3));
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

}
