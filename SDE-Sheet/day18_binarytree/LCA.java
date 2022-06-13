package day18_binarytree;

import day17_binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LCA {
    public TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        TreeNode lca = root;
        // System.out.println(contains(root.left, p, q));
        if(root.left != null && contains(root.left, p, q)) {
            lca = lowestCommonAncestorBrute(root.left, p, q);
        } else if(root.right != null && contains(root.right, p, q)) {
            lca = lowestCommonAncestorBrute(root.right, p, q);
        }

        return lca;
    }

    public boolean contains(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        boolean first_avail = false, second_avail = false;
        queue.add(root);

        if(!first_avail && root == p)
            first_avail = true;
        else if(!second_avail && root == q)
            second_avail = true;


        while(!queue.isEmpty() && (!first_avail || !second_avail)) {
            TreeNode front = queue.poll();
            // System.out.print(front.val + "->");
            if(front == p)
                first_avail = true;
            else if(front == q)
                second_avail = true;

            if(front.left != null) {
                queue.add(front.left);
            }
            if(front.right != null){
                queue.add(front.right);
            }
        }

        return first_avail && second_avail;
    }



    // better approach
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        // if either of p or q is equal to root then root is lca
        if(root == p || root == q) return root;

        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);

//        // if one of either leftLca or rightLca is null then that means the lca is present in either left or right subtree whichever was not null
//        if(leftLca == null && rightLca != null)
//            return rightLca;
//
//        else if(rightLca == null && leftLca != null)
//            return leftLca;
//
//        // else if both of them are not null and given they exist, so they must in separate subtree of which lca is root
//        else if(leftLca != null && rightLca != null)
//            return root;
//        else
//            return null;

        if(leftLca != null && rightLca != null)
            return root;

        return (leftLca != null) ? leftLca : rightLca;
    }
}
