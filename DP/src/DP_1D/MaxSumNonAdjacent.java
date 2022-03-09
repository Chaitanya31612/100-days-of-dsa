package DP_1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSumNonAdjacent {

    public static int maxSum(int idx, ArrayList<Integer> nums) {
        // base case
        if(idx == 0) return nums.get(0);
        if(idx < 0) return 0;

        // recursive case
        int pick = nums.get(idx) + maxSum(idx - 2, nums);

        int notPick = maxSum(idx - 1, nums);

        return Math.max(pick, notPick);
    }

    public static int maxSum1(int idx, ArrayList<Integer> nums) {
        // base case
        if(idx == nums.size() - 1) return nums.get(idx);
        if(idx >= nums.size()) return 0;

        // recursive case
        int pick = nums.get(idx) + maxSum1(idx + 2, nums);

        int notPick = maxSum1(idx + 1, nums);

        return Math.max(pick, notPick);
    }


    // memoization
    public static int maxSumMem(int idx, ArrayList<Integer> nums, int[] dp) {
        // base case
        if(idx == 0) return nums.get(0);
        if(idx < 0) return 0;

        if(dp[idx] != -1)
            return dp[idx];

        // recursive case
        int pick = nums.get(idx) + maxSumMem(idx - 2, nums, dp);

        int notPick = maxSumMem(idx - 1, nums, dp);

        return dp[idx] = Math.max(pick, notPick);
    }


    // DP solution (bottom up)
    public static int maxSumDP(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        dp[0] = nums.get(0);

        for(int i = 1; i < n; i++) {
            int pick = nums.get(i);
            if(i >= 2) pick += dp[i-2];

            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n-1];
    }

    // space optimisation
    public static int maxSumSpaceOptimisation(ArrayList<Integer> nums) {
        int prev2 = 0, prev = nums.get(0);

        for(int i = 1; i < nums.size(); i++) {
            int pick = nums.get(i);
            if(i >= 2) pick += prev2;
            int notPick = prev;
            prev2 = prev;
            prev = Math.max(pick, notPick);
        }
        return prev;
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int n = nums.size();

        // Method 1
//        return maxSum(n-1, nums);
        // Method 2
//        return maxSum1(0, nums);

        // Method 3
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        return maxSumMem(n-1, nums, dp);

        // Method 4
//        return maxSumDP(nums);

        // Method 5
        return maxSumSpaceOptimisation(nums);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        System.out.println(maximumNonAdjacentSum(nums));
    }
}
