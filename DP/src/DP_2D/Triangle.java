package DP_2D;

import java.util.Arrays;
// https://www.codingninjas.com/codestudio/problems/triangle_1229398
public class Triangle {
    public static int minSum(int i, int j, int[][] triangle, int[][] dp) {
        if(i == triangle.length-1)
            return triangle[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];
        int down = minSum(i+1, j, triangle, dp);
        int diag = minSum(i+1, j+1, triangle, dp);
        return dp[i][j] = triangle[i][j] + Math.min(down, diag);
    }

    public static int minimumPathSumMem(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        return minSum(0, 0, triangle, dp);
    }

    public static int minimumPathSumDP(int[][] triangle, int n) {
        int[][] dp = new int[n][n];

        for(int i = n-1; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                if(i == n-1) {
                    dp[i][j] = triangle[i][j];
                }
                else {
                    int down = dp[i+1][j];
                    int diag = dp[i+1][j+1];
                    dp[i][j] = triangle[i][j] + Math.min(down, diag);
                }
            }
        }

        return dp[0][0];
    }
}
