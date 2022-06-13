package day21_bst;

import day17_binarytree.TreeNode;

import java.util.HashSet;

public class TwoSum {
    public boolean findTargetBrute(TreeNode root, int k) {
        return findTargetUtil(root, root, k);
    }

    public boolean findTargetUtil(TreeNode root, TreeNode oldroot, int k) {
        if(root == null) return false;

        System.out.println(k-root.val);

        if(k-root.val != root.val && contains(oldroot, k-root.val))
            return true;

        return findTargetUtil(root.left, oldroot, k) || findTargetUtil(root.right, oldroot, k);
    }

    public boolean contains(TreeNode root, int key) {
        if(root == null) return false;
        if(root.val == key) return true;

        if(key < root.val)
            return contains(root.left, key);

        else
            return contains(root.right, key);
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return traversal(root, set, k);
    }

    public boolean traversal(TreeNode root, HashSet<Integer> set, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);

        return traversal(root.left, set, k) || traversal(root.right, set, k);
    }
}
