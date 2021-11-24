package day20;

import day17.TreeNode;

public class SortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedUtil(nums, 0, nums.length - 1);
    }

    public TreeNode sortedUtil(int[] nums, int s, int e) {
        if(s > e) return null;

        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedUtil(nums, s, mid-1);
        root.right = sortedUtil(nums, mid+1, e);

        return root;
    }
}
