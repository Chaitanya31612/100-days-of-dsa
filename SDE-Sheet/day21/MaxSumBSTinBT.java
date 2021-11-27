package day21;

import day17.TreeNode;

public class MaxSumBSTinBT {
    int maxsum = 0;
    public int maxSumBSTBrute(TreeNode root) {
        if(root == null) return 0;

        if(isValidBST(root))
            maxsum = Math.max(maxsum, sumTree(root));

        maxSumBSTBrute(root.left);
        maxSumBSTBrute(root.right);

        return maxsum;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode root, long minRange, long maxRange) {
        if(root == null) return true;

        if(root.val <= minRange || root.val >= maxRange) return false;

        return isValidBSTUtil(root.left, minRange, root.val) && isValidBSTUtil(root.right, root.val, maxRange);
    }

    public int sumTree(TreeNode root) {
        if(root == null) return 0;

        return root.val + sumTree(root.left) + sumTree(root.right);
    }

    public static void main(String[] args) {

    }
}
