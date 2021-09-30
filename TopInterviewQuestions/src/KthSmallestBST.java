/*
* explanation - https://leetcode.com/problems/kth-smallest-element-in-a-bst/discuss/1493372/easy-java-recursive-solution
* */

import java.util.Scanner;

public class KthSmallestBST {
    public static int kthSmallestTry(TreeNode root, int k) {
        if(root == null)
            return -1;

        TreeNode slow = root, fast = root;

        while(fast != null && k > 0) {
            fast = fast.left;
            k--;
        }

        if(k != 0){
            if(root.right == null)
                return root.val;
            slow = root.right;
            fast = root.right;

            while(fast != null && k > 0) {
                fast = fast.left;
                k--;
            }
        }
        while(fast != null) {
            fast = fast.left;
            slow = slow.left;
        }

        return slow.val;
    }

    public static int findMin(TreeNode root) {
        if(root == null)
            return -1;

        TreeNode temp = root;
        while(temp.left != null) {
            temp = temp.left;
        }

        return temp.val;
    }

    static int count = 0, result = Integer.MAX_VALUE;

    public static int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return result;
    }

    private static void traversal(TreeNode root, int k) {
        if(root == null)
            return;
        traversal(root.left, k);
        count++;
        if(count == k) {
            result = root.val;
            return;
        }
        traversal(root.right, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode t = new TreeNode();
        TreeNode root = t.inputLevel();
        System.out.println("Enter k");
        int k = sc.nextInt();
        System.out.println(kthSmallest(root, k));
//        System.out.println(findMin(root));
    }
}