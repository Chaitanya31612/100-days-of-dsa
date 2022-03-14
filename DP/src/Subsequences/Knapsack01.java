package Subsequences;

import java.util.Arrays;

public class Knapsack01 {
    public static int maxValue(int idx, int W, int[] weight, int[] value, int[][] dp) {
        if(idx == 0)
            if(weight[0] <= W)
                return value[0];
            else
                return 0;

        if(dp[idx][W] != -1)
            return dp[idx][W];

        int nottake = maxValue(idx-1, W, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= W)
            take = value[idx] + maxValue(idx-1, W-weight[idx], weight, value, dp);

        return dp[idx][W] = Math.max(nottake, take);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        return maxValue(n-1, maxWeight, weight, value, dp);
    }

    static int knapsackDP(int[] weight, int[] value, int n, int W) {
        int[][] dp = new int[n][W+1];

        for(int wt = weight[0]; wt <= W; wt++)
            dp[0][wt] = value[0];

        for(int i = 1; i < n; i++) {
            for(int wt = 1; wt <= W; wt++) {
                int nottake = dp[i-1][wt];
                int take = Integer.MIN_VALUE;
                if(weight[i] <= wt)
                    take = value[i] + dp[i-1][wt-weight[i]];
                dp[i][wt] = Math.max(nottake, take);
            }
        }

        return dp[n-1][W];
    }
}