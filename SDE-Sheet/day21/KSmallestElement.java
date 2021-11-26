package day21;

import day17.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KSmallestElement {
    public int kthSmallestBrute(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        return list.get(k-1);
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if(root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // count - for checking kth smallest element
    // result - store the kth element value
    int count = 0, result = -1;

    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return result;
    }

    private void traversal(TreeNode root, int k) {
        if(root == null)
            return;

        // check the left because of bst property, left is smallest
        traversal(root.left, k);

        // increment the count and check if k are traversed
        count++;
        if(count == k) {
            result = root.val;
            return;
        }

        // if not, then traverse the right tree if there
        traversal(root.right, k);
    }
}
