/* explanation - https://leetcode.com/problems/range-sum-of-bst/discuss/1495551/java-easy-solution*/

public class RangeSum {
    static int sum = 0;
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;

        if(root.val > high) {
            rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            rangeSumBST(root.right, low, high);
        } else {
            if (root.val >= low && root.val <= high) {
                sum += root.val;
            }
            rangeSumBST(root.left, low, high);
            rangeSumBST(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args) {
        BSTNode bst = new BSTNode();
        TreeNode root = bst.input();

        System.out.println(rangeSumBST(root, 7, 15));
    }
}
