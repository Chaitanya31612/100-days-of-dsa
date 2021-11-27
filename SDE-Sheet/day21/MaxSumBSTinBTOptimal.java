package day21;

import day17.TreeNode;

public class MaxSumBSTinBTOptimal {
    int maxsum = 0;
    public int maxSumBST(TreeNode root) {
        postorder(root);
        return maxsum;
    }

    private int[] postorder(TreeNode root) {
        if(root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}

        // postorder -> Left Right Root
        int[] leftTree = postorder(root.left);
        int[] rightTree = postorder(root.right);

        if(leftTree == null ||
                rightTree == null ||
                root.val <= leftTree[1] ||
                root.val >= rightTree[0]
        ) {
            return null;
        }

        int sum = root.val + leftTree[2] + rightTree[2];
        maxsum = Math.max(maxsum, sum);

        int max = Math.max(root.val, rightTree[1]);
        int min = Math.min(root.val, leftTree[0]);

        return new int[]{min, max, sum};
    }
}
