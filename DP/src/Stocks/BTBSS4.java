package Stocks;

public class BTBSS4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for(int i = n-1; i >= 0; i--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = k; cap > 0; cap--) {
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

        return dp[0][1][k];
    }
}
