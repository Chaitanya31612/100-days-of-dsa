/*
* https://leetcode.com/problems/maximum-binary-tree/discuss/1497082/easy-to-understand-java-solution
* */

import java.util.Scanner;

public class MaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTreeUtil(nums, 0, nums.length - 1);
    }

    private static TreeNode constructMaximumBinaryTreeUtil(int[] nums, int s, int e) {
        if(s > e)
            return null;

        int maxInd = findMaxInd(nums, s, e);
        TreeNode root = new TreeNode(nums[maxInd]);
        root.left = constructMaximumBinaryTreeUtil(nums, s, maxInd - 1);
        root.right = constructMaximumBinaryTreeUtil(nums, maxInd + 1, e);

        return root;
    }

    private static int findMaxInd(int[] nums, int s, int e) {
        int max = Integer.MIN_VALUE, maxInd = -1;
        for(int i = s; i <= e; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxInd = i;
            }
        }

        return maxInd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();


    }
}
