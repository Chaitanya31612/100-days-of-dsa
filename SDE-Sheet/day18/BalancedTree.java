package day18;

import day17.TreeNode;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return customHeight(root) != -1;
    }

    public int customHeight(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = customHeight(root.left);

        if(leftHeight == -1) // if left subtree is not balanced
            return -1;

        int rightHeight = customHeight(root.right);

        if(rightHeight == -1) // if right subtree is not balanced
            return -1;

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalancedBrute(TreeNode root) {
        if(root == null) return true;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);

        if((Math.abs(leftHeight - rightHeight) <= 1) && leftAns && rightAns)
            return true;

        return false;
    }

    public int height(TreeNode root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
