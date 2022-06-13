package day18_binarytree;

import day17_binarytree.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/1589895/Java-clean-and-short-recursive-solution
public class MaxDepthHeight {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
