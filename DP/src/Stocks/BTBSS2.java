package Stocks;

import java.util.Arrays;

public class BTBSS2 {
    // memoization
    public int f(int idx, int buy, int[] prices, int[][] dp) {
        if(idx == prices.length) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int profit = 0;
        if(buy == 1) {
            profit = Math.max((-prices[idx] + f(idx+1, 0, prices, dp)), // buy and add -price because it will be deducted from final selling day (money invested -> money spent)
                    (f(idx+1, 1, prices, dp))); // don't buy, move on
        } else {
            profit = Math.max((prices[idx] + f(idx+1, 1, prices, dp)), // sell and add profit(money coming)
                    (f(idx+1, 0, prices, dp))); // don't sell, move on
        }

        return dp[idx][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return f(0, 1, prices, dp);
    }



    // DP
    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        // move in reverse order as used in memoization code
        dp[n][0] = dp[n][1] = 0; // base case
        // move idx from n-1 to 0
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max((-prices[idx] + dp[idx+1][0]),
                            dp[idx+1][1]);
                } else {
                    profit = Math.max((prices[idx] + dp[idx+1][1]),
                            dp[idx+1][0]);
                }
                dp[idx][buy] = profit;
            }

        }

        return dp[0][1];
    }

    // space optimized DP
    public int maxProfitSpace(int[] prices) {
        int n = prices.length;
        int a = 0, b = 0;
        for(int idx = n-1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    profit = Math.max((-prices[idx] + a), b);
                } else {
                    profit = Math.max((prices[idx] + b), a);
                }
                a = buy == 0 ? profit : a;
                b = buy == 1 ? profit : b;
            }

        }

        return b;
    }
}
