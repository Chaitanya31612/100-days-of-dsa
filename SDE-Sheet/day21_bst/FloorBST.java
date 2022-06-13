package day21_bst;

import day17_binarytree.TreeNode;

public class FloorBST {
    public static int floorInBST(TreeNode root, int key) {
        int floor = -1;
        while(root != null) {
            if(root.val == key) {
                floor = root.val;
                return floor;
            }
            if(root.val < key) {
                floor = root.val;
                root = root.right;
            }
            else {
                root = root.left;
            }
        }

        return floor;
    }

    public static int ceilBST(TreeNode root, int key) {
        int floor = -1;
        while(root != null) {
            if(root.val == key) {
                return floor = root.val;
            }

            if(root.val > key) {
                floor = root.val;
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return floor;
    }

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();

        TreeNode root = tn.takeInput();

        System.out.println(floorInBST(root, 14));
        System.out.println(ceilBST(root, 14));
    }
}
