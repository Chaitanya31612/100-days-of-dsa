package day19_binarytree;

import day17_binarytree.TreeNode;

public class MirrorTree {
    void mirror(TreeNode root)
    {
        // Your code here
        if(root == null) {
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
