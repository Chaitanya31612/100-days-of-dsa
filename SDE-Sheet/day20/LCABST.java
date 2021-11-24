package day20;

import day17.TreeNode;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/discuss/1594585/Java-easy-and-concise-solution-oror-Recursive
public class LCABST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }
}
