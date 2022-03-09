package DP_3D;

import java.util.Arrays;
// https://www.codingninjas.com/codestudio/problems/ninja-and-his-friends_3125885?
// https://www.youtube.com/watch?v=QGfn7JeXK54
public class NinjaFriends3D {
    public static int maxVal(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j2 < 0 || j1 >= grid[0].length || j2 >= grid[0].length)
            return (int)(-1e8);
        if(i == grid.length-1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                int val = 0;
                val += maxVal(i+1, j1+d1, j2+d2, grid, dp);
                if(j1 == j2) {
                    val += grid[i][j1];
                } else {
                    val += grid[i][j1] + grid[i][j2];
                }
                max = Math.max(max, val);
            }
        }

        return dp[i][j1][j2] = max;
    }
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][m];
        for(int[][] ar1: dp)
            for(int[] ar2: ar1)
                Arrays.fill(ar2, -1);
        return maxVal(0, 0, m-1, grid, dp);
    }
}
