package Stocks;

import java.util.Arrays;

public class BTBSSwithCooldown {
    public int f(int i, int buy, int[] prices, int[][] dp) {
        if(i >= prices.length) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max(-prices[i] + f(i+1, 0, prices, dp), f(i+1, 1, prices, dp));
        } else {
            profit = Math.max(prices[i] + f(i+2, 1, prices, dp), f(i+1, 0, prices, dp));
        }
        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        return f(0, 1, prices, dp);
    }


    // DP
    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        // base case
        dp[n][0] = dp[n][1] = 0;

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    profit = dp[i+1][0];
                    int pr = prices[i];
                    if(i+2 <= n) pr += dp[i+2][1];
                    profit = Math.max(profit, pr);
                }
                dp[i][buy] = profit;
            }
        }

        return dp[0][1];
    }
}
