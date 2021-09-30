public class DeepestLeavesSum {
    static int sum;
    public static int sumOfLeaves(TreeNode root) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null) {
            sum += root.val;
        }

        sumOfLeaves(root.left);
        sumOfLeaves(root.right);

        return sum;
    }

    public static int deepestLeavesSum(TreeNode root) {
        int maxLevel = depth(root);
        return deepestLeavesSumUtil(root, 1, maxLevel);
    }

    private static int depth(TreeNode root) {
        if(root == null)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static int deepestLeavesSumUtil(TreeNode root, int count, int maxLevel) {
        if(root == null)
            return 0;

        if(root.left == null && root.right == null && count == maxLevel) {
            sum += root.val;
        }

        deepestLeavesSumUtil(root.left, count + 1, maxLevel);
        deepestLeavesSumUtil(root.right, count + 1, maxLevel);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode();
        TreeNode root = t.inputLevel();

//        System.out.println(deepestLeavesSum(root));
//        System.out.println(depth(root));
        System.out.println(deepestLeavesSum(root));
    }
}
