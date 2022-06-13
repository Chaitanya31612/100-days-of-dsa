package day26_dp;

import java.util.Arrays;

public class CoinChange {
    public int f(int i, int target, int[] coins, int[][] dp) {
        if(i < 0) return (int)1e7;
        if(i == 0) {
            if(target % coins[i] == 0)
                return target / coins[i];
            return (int)1e7;
        }

        if(dp[i][target] != -1)
            return dp[i][target];

        int notpick = f(i-1, target, coins, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= target) {
            pick = 1 + f(i, target-coins[i], coins, dp);
        }

        return dp[i][target] = Math.min(notpick, pick);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        int ans = f(n-1, amount, coins, dp);

//        for(int[] ar: dp)
//            System.out.println(Arrays.toString(ar));

        if(ans >= (int)1e7)
            return -1;

        return ans;
    }

    // DP
    public int coinChangeDP(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int target = 1; target <= amount; target++) {
            if(target % coins[0] == 0)
                dp[0][target] = target / coins[0];
            else
                dp[0][target] = (int)1e7;
        }

        for(int i = 1; i < n; i++) {
            for(int target = 1; target <= amount; target++) {
                int notpick = dp[i-1][target];
                int pick = Integer.MAX_VALUE;
                if(coins[i] <= target)
                    pick = 1 + dp[i][target-coins[i]];

                dp[i][target] = Math.min(notpick, pick);
            }
        }

        int ans = dp[n-1][amount];
        if(ans >= (int)1e7)
            return -1;

        return ans;
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(c.coinChange(coins, amount));
    }

}
