package Stocks;

import java.util.Arrays;

public class BTBSS3 {
    // memoization
    public int f(int i, int buy, int cap, int[] prices, int[][][] dp) {
        if(cap == 0 || i == prices.length) return 0;

        if(dp[i][buy][cap] != -1) return dp[i][buy][cap];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[i] + f(i+1, 0, cap, prices, dp), f(i+1, 1, cap, prices, dp));
        } else {
            profit = Math.max(prices[i] + f(i+1, 1, cap-1, prices, dp), f(i+1, 0, cap, prices, dp));
        }
        return dp[i][buy][cap] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] arr: dp)
            for(int[] ar: arr)
                Arrays.fill(ar, -1);
        return f(0, 1, 2, prices, dp);
    }

    // DP
    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 2; cap > 0; cap--) {
                    int profit = 0;
                    if(buy == 1) {
                        profit = Math.max(-prices[i] + dp[i+1][0][cap], dp[i+1][1][cap]);
                    } else {
                        profit = Math.max(prices[i] + dp[i+1][1][cap-1], dp[i+1][0][cap]);
                    }
                    dp[i][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }
}
