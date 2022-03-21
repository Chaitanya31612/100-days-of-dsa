package Subsequences;

import java.util.Arrays;

//https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284

public class RodCutting {
    // write memoization solution by thinking in opposite direction
    public static int maxCost(int idx, int N, int[] price, int[][] dp) {
        if(idx == 0) {
            return N * price[0];
        }

        if(dp[idx][N] != -1)
            return dp[idx][N];

        int notpick = maxCost(idx-1, N, price, dp);
        int pick = Integer.MIN_VALUE;
        int rodlength = idx+1;
        if(rodlength <= N)
            pick = price[idx] + maxCost(idx, N-rodlength, price, dp);

        return dp[idx][N] = Math.max(notpick, pick);
    }
    public static int cutRod(int price[], int n) {
        int[][] dp = new int[n][n+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return maxCost(n-1, n, price, dp);
    }

    // DP
    public static int cutRodDP(int price[], int n) {
        int[][] dp = new int[n][n+1];

        for(int N = 0; N <= n; N++) {
            dp[0][N] = N * price[0];
        }

        for(int idx = 1; idx < n; idx++) {
            for(int N = 0; N <= n; N++) {
                int notpick = dp[idx-1][N];
                int pick = Integer.MIN_VALUE;
                int rodlength = idx+1;
                if(rodlength <= N)
                    pick = price[idx] + dp[idx][N-rodlength];
                dp[idx][N] = Math.max(notpick, pick);
            }
        }
        return dp[n-1][n];
    }
}
