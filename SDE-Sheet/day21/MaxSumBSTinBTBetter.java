package day21;

import day17.TreeNode;

public class MaxSumBSTinBTBetter {
    int maxsum = 0;
    public int maxSumBST(TreeNode root) {
        if(root == null) return 0;

        boolean isBST = isValidBST(root);
        int[] sumAndNeg = new int[2];
        sumAndNeg = sumTree(root, sumAndNeg);

        if(isBST)
            maxsum = Math.max(maxsum, sumAndNeg[0]);

        if(!isBST || sumAndNeg[1] == 1) {
            maxSumBST(root.left);
            maxSumBST(root.right);
        }

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

    public int[] sumTree(TreeNode root, int[] arr) {
        if(root == null) return new int[]{0, arr[1]};

        if(root.val < 0) {
            arr[1] = 1;
        }
        arr[0] = root.val + sumTree(root.left, arr)[0] + sumTree(root.right, arr)[0];
        return arr;
    }
}
