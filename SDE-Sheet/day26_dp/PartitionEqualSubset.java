package day26_dp;

import java.util.Arrays;

public class PartitionEqualSubset {
    // Memoization
    public boolean f(int i, int target, int[] nums, int[][] dp) {
        if(target == 0) return true;
        if(i == 0) return target == nums[0];

        if(dp[i][target] != -1) {
            return dp[i][target] == 1 ? true : false;
        }

        boolean notpick = f(i-1, target, nums, dp);
        boolean pick = false;
        if(nums[i] <= target)
            pick = f(i-1, target-nums[i], nums, dp);

        dp[i][target] = notpick || pick ? 1 : 0;
        return notpick || pick;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int el: nums)
            sum += el;

        // if sum is odd return false
        if((sum&1) == 1) return false;
        int n = nums.length;
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return f(n-1, target, nums, dp);
    }


}
