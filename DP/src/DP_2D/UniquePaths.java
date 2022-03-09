package DP_2D;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths {

    public static int uniquePathsRec(int m, int n) {
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;

        // recursive case
        int up = uniquePathsRec(m-1, n);
        int left = uniquePathsRec(m, n-1);

        return up + left;
    }

    // memoization
    public static int uniquePathsMemo(int m, int n, int[][] dp) {
        if(m == 0 && n == 0)
            return 1;
        if(m < 0 || n < 0)
            return 0;

        if(dp[m][n] != -1)
            return dp[m][n];

        int up = uniquePathsMemo(m-1, n, dp);
        int left = uniquePathsMemo(m, n-1, dp);

        return dp[m][n] = up + left;
    }

    // dynamic programming
    public static int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    int up = dp[i-1][j];
                    int left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePathsRec(m-1, n-1));
        int[][] dp = new int[m][n];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        System.out.println(uniquePathsMemo(m-1, n-1, dp));
    }
}
