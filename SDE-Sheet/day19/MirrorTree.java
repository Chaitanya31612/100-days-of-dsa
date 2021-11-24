package day19;

import day17.TreeNode;

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
