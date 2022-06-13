package day26_dp;

import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/

public class EggDropping {
    static int f(int n, int k, int[][] dp) {
        if(k == 0) return 0;
        // we assume worst, i.e. egg breaks from top only and not in middle
        if(n == 1 && k > 0) return k;

        if(dp[n][k] != -1)
            return dp[n][k];

        int min = Integer.MAX_VALUE;
        for(int x = 1; x <= k; x++) {
            // if egg breaks at xth floor then check for remaining floors below it
            int breaks = f(n-1, x-1, dp);
            // if egg doesn't break at xth floor then check for remaining floors above it
            int dontbreak = f(n, k-x, dp);
            // we need to find min moves to find the highest floor
            // in questions of guarantee we find best of the worst
            min = Math.min(min, Math.max(breaks, dontbreak));
        }

        return dp[n][k] = min+1;
    }

    static int eggDrop(int n, int k)
    {
        int[][] dp = new int[n+1][k+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return f(n, k, dp);
    }


    // DP
    static int eggDropDP(int n, int k)
    {
        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i <= k; i++)
            dp[1][i] = i;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for(int x = 1; x <= j; x++) {
                    int breaks = dp[i-1][x-1];
                    int notbreaks = dp[i][j-x];
                    min = Math.min(min, Math.max(breaks, notbreaks));
                }

                dp[i][j] = min + 1;
            }
        }

        return dp[n][k];
    }
}
