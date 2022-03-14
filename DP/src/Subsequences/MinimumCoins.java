package Subsequences;

import java.util.Arrays;
// https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091?leftPanelTab=1
public class MinimumCoins {
    public static int minElements(int idx, int target, int[] nums, int[][] dp) {
        if(idx == 0) {
            if(target % nums[0] == 0)
                return target / nums[0];
            else
                return (int)1e9;
        }

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int nottake = minElements(idx-1, target, nums, dp);
        int take = Integer.MAX_VALUE;
        if(nums[idx] <= target)
            take = 1 + minElements(idx, target-nums[idx], nums, dp);

        return dp[idx][target] = Math.min(nottake, take);
    }

    public static int minimumElements(int nums[], int x) {
        int n = nums.length;
        int[][] dp = new int[n][x+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        int ans = minElements(n-1, x, nums, dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }

    public static int minimumElementsDP(int nums[], int x) {
        int n = nums.length;
        int[][] dp = new int[n][x+1];

        for(int t = 0; t <= x; t++) {
            if(t % nums[0] == 0)
                dp[0][t] = t / nums[0];
            else
                dp[0][t] = (int)1e9;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= x; t++) {
                int nottake = dp[i-1][t];
                int take = Integer.MAX_VALUE;
                if(nums[i] <= t)
                    take = 1 + dp[i][t-nums[i]];
                dp[i][t] = Math.min(take, nottake);
            }
        }
        return dp[n-1][x] == (int)1e9 ? -1 : dp[n-1][x];
    }
}
