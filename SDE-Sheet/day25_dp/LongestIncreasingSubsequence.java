package day25_dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        int last = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(nums[i-1] == sorted[j-1] && nums[i-1] != last) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    last = nums[i-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][n];
    }
}
