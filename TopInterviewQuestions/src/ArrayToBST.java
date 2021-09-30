/*
*
* explanation - https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/1495234/easy-java-recursive-solution
* */

public class ArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTUtil(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTUtil(int[] nums, int si, int ei) {
        if(si > ei)
            return null;

        int mid = si + (ei - si) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTUtil(nums, si, mid - 1);
        root.right = sortedArrayToBSTUtil(nums, mid + 1, ei);

        return root;
    }

    public static void main(String[] args) {
        BSTNode bst = new BSTNode();
        TreeNode root = bst.input();
        bst.print(root);

//        bst.delete(root, 5);
//        bst.print(root);
//        root = bst.balancedBST(root);
//        bst.print(root);

    }
}

/*
5 3 6 2 4 1
* */