package day18_binarytree;

import day17_binarytree.TreeNode;

//https://leetcode.com/problems/same-tree/discuss/1590128/Java-easy-intuitive-solution-oror-Recursion-0ms-100-faster
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) || (q == null && p != null)) return false;

        boolean leftAns = isSameTree(p.left, q.left);
        boolean rightAns = isSameTree(p.right, q.right);

        if(leftAns && rightAns && p.val == q.val) {
            return true;
        }

        return false;
    }
}
