package day19;

import day17.TreeNode;

public class PostorderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeUtil(inorder, postorder, 0, inorder.length-1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeUtil(int[] inorder, int[] postorder, int inS, int inE, int postS, int postE) {
        if(inS > inE) return null;

        int rootData = postorder[postE];
        TreeNode root = new TreeNode(rootData);
        int rootIdx = -1;

        for(int i = inS; i <= inE; i++) {
            if(inorder[i] == rootData) {
                rootIdx = i;
                break;
            }
        }

        int leftInS = inS;
        int leftInE = rootIdx - 1;
        int leftPostS = postS;
        int leftPostE = leftPostS + (leftInE - leftInS);

        int rightInS = rootIdx + 1;
        int rightInE = inE;
        int rightPostS = leftPostE + 1;
        int rightPostE = postE - 1;

        root.left = buildTreeUtil(inorder, postorder, leftInS, leftInE, leftPostS, leftPostE);
        root.right = buildTreeUtil(inorder, postorder, rightInS, rightInE, rightPostS, rightPostE);

        return root;
    }
}
