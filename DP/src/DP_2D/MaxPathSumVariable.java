package DP_2D;

import java.util.Arrays;
// https://www.codingninjas.com/codestudio/problems/maximum-path-sum-in-the-matrix_797998
public class MaxPathSumVariable {
    public static int maxPathSum(int i, int j, int[][] matrix, int[][] dp) {
        if(i < 0 || j < 0 || j >= matrix[0].length) {
            return Integer.MIN_VALUE;
        }
        if(i == 0) return matrix[i][j];

        if(dp[i][j] != -1)
            return dp[i][j];

        int up = maxPathSum(i-1, j, matrix, dp);
        int ld = maxPathSum(i-1, j-1, matrix, dp);
        int rd = maxPathSum(i-1, j+1, matrix, dp);

        return dp[i][j] = matrix[i][j] + Math.max(up, Math.max(ld, rd));
    }

    public static int getMaxPathSumMem(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        for(int j = 0; j < m; j++) {
            max = Math.max(max, maxPathSum(n-1, j, matrix, dp));
        }
        return max;
    }

    public static int getMaxPathSumDP(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int up, ld, rd;
                    up = ld = rd = Integer.MIN_VALUE;
                    if(i > 0) up = dp[i-1][j];
                    if(i > 0 && j > 0) ld = dp[i-1][j-1];
                    if(i > 0 && j < m-1) rd = dp[i-1][j+1];

                    dp[i][j] = matrix[i][j] + Math.max(up, Math.max(ld, rd));
                }
            }
        }

        for(int j = 0; j < m; j++) {
            max = Math.max(max, dp[n-1][j]);
        }
        return max;
    }
}

