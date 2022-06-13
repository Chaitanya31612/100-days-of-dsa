package day25_dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {
    public static int findMax(int i, int w, ArrayList<Integer> values, ArrayList<Integer> weights, int[][] dp) {
        if(i < 0) return 0;

        if(dp[i][w] != -1)
            return dp[i][w];

        int notpick = findMax(i-1, w, values, weights, dp);
        int pick = 0;
        if(weights.get(i) <= w)
            pick = values.get(i) + findMax(i-1, w-weights.get(i), values, weights, dp);

        return dp[i][w] = Math.max(notpick, pick);
    }

    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return findMax(n-1, w, values, weights, dp);
    }

    // DP
    public static int maxProfitDP(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[n+1][w+1];

        for(int i = 1; i <= n; i++) {
            for(int wt = 0; wt <= w; wt++) {
                int notpick = 0, pick = 0;
                notpick = dp[i-1][wt];
                if(weights.get(i-1) <= wt)
                    pick = values.get(i-1) + dp[i-1][wt-weights.get(i-1)];
                dp[i][wt] = Math.max(notpick, pick);
            }
        }

        return dp[n][w];
    }
}
