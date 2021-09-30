/*https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/*/

import java.util.ArrayList;

public class BSTtoGST {
    static int presum = 0;
    public static TreeNode bstToGstBetter(TreeNode root) {
        if(root == null)
            return null;

        if(root.right != null)
            bstToGstBetter(root.right);
        presum += root.val;
        root.val = presum;

        if(root.left != null)
            bstToGstBetter(root.left);

        return root;
    }

    public static TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> nodes = new ArrayList<>();

        getNodes(root, nodes);

        System.out.println(nodes);
        int cum = 0;
        for(int i = nodes.size() - 1; i >= 0; i--) {
            nodes.set(i, nodes.get(i) + cum);
            cum = nodes.get(i);
        }
        System.out.println(nodes);

        updateNodes(root, nodes);
        return root;
    }
    
    private static void getNodes(TreeNode root, ArrayList<Integer> nodes) {
        if(root == null) {
            return;
        }

        getNodes(root.left, nodes);
        nodes.add(root.val);
        getNodes(root.right, nodes);
    }

    static int index = 0;
    private static void updateNodes(TreeNode root, ArrayList<Integer> nodes) {
        if(root == null)
            return;

        updateNodes(root.left, nodes);
        root.val = nodes.get(index++);
        updateNodes(root.right, nodes);
    }

    public static void main(String[] args) {
        BSTNode bst = new BSTNode();
        TreeNode root = bst.input();
        bst.print(root);
        root = bstToGstBetter(root);
        bst.print(root);
    }
}
