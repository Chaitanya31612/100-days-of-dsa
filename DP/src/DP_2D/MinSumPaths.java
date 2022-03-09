package DP_2D;

import java.util.Arrays;
import java.util.Scanner;

// https://www.codingninjas.com/codestudio/problems/minimum-path-sum_985349

public class MinSumPaths {
    public static int minPaths(int i, int j, int[][] grid, int[][] dp) {
        if(i == 0 && j == 0)
            return grid[0][0];
        if(i < 0 || j < 0)
            return Integer.MAX_VALUE;

        if(dp[i][j] != -1)
            return dp[i][j];

        int up = minPaths(i-1, j, grid, dp);
        int left = minPaths(i, j-1, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }

    public static int minSumPathMem(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);

        return minPaths(n-1, m-1, grid, dp);
    }

    public static int minSumPathDP(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    int up=Integer.MAX_VALUE, left=Integer.MAX_VALUE;
                    if(i > 0)
                        up = dp[i-1][j];
                    if(j > 0)
                        left = dp[i][j-1];
                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(minSumPathMem(grid));
    }
}
