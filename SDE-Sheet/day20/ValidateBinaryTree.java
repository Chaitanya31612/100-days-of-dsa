package day20;

import day17.TreeNode;

public class ValidateBinaryTree {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        // if(root.left == null && root.right == null)
        //     return true;

        boolean leftBST = isValidBST(root.left);
        boolean rightBST = isValidBST(root.right);

        if(!leftBST || !rightBST)
            return false;

        long maxLeft = maximum(root.left);
        long minRight = minimum(root.right);


        return (maxLeft == Long.MIN_VALUE || root.val > maxLeft) && (minRight == Long.MAX_VALUE || root.val < minRight);
    }

    public long maximum(TreeNode root) {
        if(root == null) return Long.MIN_VALUE;

        long leftMax, rightMax;
        leftMax = rightMax = Long.MIN_VALUE;

        if(root.left != null) {
            leftMax = maximum(root.left);
        }

        if(root.right != null) {
            rightMax = maximum(root.right);
        }

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    public long minimum(TreeNode root) {
        if(root == null) return Long.MAX_VALUE;

        long leftMin, rightMin;
        leftMin = rightMin = Long.MAX_VALUE;

        if(root.left != null) {
            leftMin = minimum(root.left);
        }

        if(root.right != null) {
            rightMin = minimum(root.right);
        }

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }
}
