package day19_binarytree;

import day17_binarytree.TreeNode;

public class PreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeUtil(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTreeUtil(int[] pre, int[] in, int preS, int preE, int inS, int inE) {
        if(inS > inE) return null;
        int rootVal = pre[preS];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;

        // check in inorder array
        for(int i = inS; i <= inE; i++) {
            if(in[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        // if(rootIdx == -1) return null;

        // for left array
        int leftInS = inS;
        int leftInE = rootIdx - 1;
        int leftPreS = preS + 1;
        int leftPreE = leftPreS + (leftInE - leftInS);

        // for right array
        int rightInS = rootIdx + 1;
        int rightInE = inE;
        int rightPreS = leftPreE + 1;
        int rightPreE = preE;


        root.left = buildTreeUtil(pre, in, leftPreS, leftPreE, leftInS, leftInE);
        root.right = buildTreeUtil(pre, in, rightPreS, rightPreE, rightInS, rightInE);

        return root;
    }
}
