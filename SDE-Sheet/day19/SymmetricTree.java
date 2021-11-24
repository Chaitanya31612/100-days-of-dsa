package day19;

import day17.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetry(root.left, root.right);
    }

    private boolean checkSymmetry(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) return true;
            // this means one out of them is null
        else if(tree1 == null || tree2 == null) return false;

        boolean leftAns = checkSymmetry(tree1.left, tree2.right);
        boolean rightAns = checkSymmetry(tree1.right, tree2.left);

        if(tree1.val == tree2.val && (leftAns && rightAns)) return true;

        return false;
    }
}
