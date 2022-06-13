package day21_bst;

import day17_binarytree.Node;

public class KthLargest {
    int count = 0, ans = Integer.MIN_VALUE;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k)
    {
        traversal(root, k);
        return ans;
    }

    public void traversal(Node root, int k) {
        if(root == null) return;

        traversal(root.right, k);

        count++;
        if(count == k) {
            ans = root.data;
            return;
        }

        traversal(root.left, k);
    }
}
