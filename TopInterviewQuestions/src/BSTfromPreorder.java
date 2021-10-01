import java.util.Scanner;

public class BSTfromPreorder {
    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder, 0);
    }

    private static TreeNode bstFromPreorderUtil(int[] preorder, int ind) {
        if(ind >= preorder.length)
            return null;

        TreeNode root = new TreeNode(preorder[ind]);
        if(ind < preorder.length - 1) {
            if(preorder[ind + 1] < root.val) {
                root.left = bstFromPreorderUtil(preorder, ind + 1);
            } else {
                root.right = bstFromPreorderUtil(preorder, ind + 1);
            }
        }

        return root;
    }
    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};

        TreeNode t = new TreeNode();
        TreeNode root = bstFromPreorder(preorder);
        t.print(root);
    }

}
