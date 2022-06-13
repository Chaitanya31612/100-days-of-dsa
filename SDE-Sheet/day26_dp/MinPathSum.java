package day26_dp;

import java.util.Arrays;

public class MinPathSum {
    public int f(int i, int j, int[][] grid, int[][] dp) {
        if(i < 0 || j < 0) return (int)1e7;
        if(i == 0 && j == 0) return grid[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];

        int up = f(i-1, j, grid, dp);
        int left = f(i, j-1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return f(m-1, n-1, grid, dp);
    }

    // DP
    public int minPathSumDP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i = 0; i <= m; i++) dp[i][0] = (int)1e7;
        for(int j = 0; j <= n; j++) dp[0][j] = (int)1e7;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == 1 && j == 1) {
                    dp[i][j] = grid[i-1][j-1];
                    continue;
                }
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = grid[i-1][j-1] + Math.min(up, left);
            }
        }

        return dp[m][n];
    }
}
