package Subsequences;

import java.util.Arrays;

public class UnboundKnapsack {
    public static int maxProfit(int idx, int wt, int[] profit, int[] weight, int[][] dp) {
        if(idx == 0) {
            if(weight[idx] <= wt)
                return (wt/weight[idx]) * profit[idx];
            return 0;
        }
        if(dp[idx][wt] != -1)
            return dp[idx][wt];

        int notpick = maxProfit(idx-1, wt, profit, weight, dp);
        int pick = -(int)1e8;
        if(weight[idx] <= wt) {
            pick = maxProfit(idx, wt-weight[idx], profit, weight, dp) + profit[idx];
        }

        return dp[idx][wt] = Math.max(notpick, pick);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return maxProfit(n-1, w, profit, weight, dp);
    }

    public static int unboundedKnapsackDP(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];

        for(int wt = 0; wt <= w; wt++) {
            if(weight[0] <= wt)
                dp[0][wt] = (wt/weight[0]) * profit[0];
        }

        for(int idx = 1; idx < n; idx++) {
            for(int wt = 0; wt <= w; wt++) {
                int notpick = dp[idx-1][wt];
                int pick = Integer.MIN_VALUE;
                if(weight[idx] <= wt)
                    pick = profit[idx] + dp[idx][wt-weight[idx]];
                dp[idx][wt] = Math.max(notpick, pick);
            }
        }

        return dp[n-1][w];
    }
}
