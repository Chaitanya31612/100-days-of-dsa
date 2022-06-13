package day3_arrays;

import java.util.Scanner;

// https://leetcode.com/problems/unique-paths/discuss/1534872/Java-all-possible-solution-or-recursion-dp-combinatorics

public class UniquePaths {

    public static int uniquePathsMem(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return uPMemHelper(m, n, 0, 0, dp);
    }

    private static int uPMemHelper(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return dp[i][j] = 1;
        }
        if (i >= m || j >= n)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        return dp[i][j] = uPMemHelper(m, n, i, j + 1, dp) + uPMemHelper(m, n, i + 1, j, dp);
    }

    public static int uniquePathsRec(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n)
            return 0;

        int c = 0;
        c += uniquePathsRec(i, j + 1, m, n);
        c += uniquePathsRec(i + 1, j, m, n);

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePathsRec(0, 0, m, n));
        System.out.println(uniquePathsMem(m, n));
        sc.close();
    }
}
