package day19_binarytree;

import day17_binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBT {
    public void flattenBrute(TreeNode root) {
        if(root == null) return;
        List<Integer> list = new ArrayList<>();
        preorder(list, root);

        root.left = null;
        root.right = null;
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                continue;
            }

            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
    }

    public void preorder(List<Integer> list, TreeNode root) {
        if(root == null) return;

        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }

    public void flatten(TreeNode root) {
        if(root == null) return;

        // flatten left and right subtree
        flatten(root.left);
        flatten(root.right);
        // if left is already null do nothing
        if(root.left == null) return;

        TreeNode rightTemp = root.right;
        root.right = root.left; // set flattened left subtree to right of root
        root.left = null;

        // traverse and find last of left subtree
        TreeNode temp = root.right;
        while(temp.right != null) {
            temp = temp.right;
        }

        temp.right = rightTemp;
    }
}
