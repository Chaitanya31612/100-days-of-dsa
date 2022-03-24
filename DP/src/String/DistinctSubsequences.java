package String;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/subsequence-counting_3755256
public class DistinctSubsequences {
    static int mod = (int)1e9 + 7;

    public static int countWays(int i, int j, String s, String t, int[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int pick = 0, notpick = 0;
        if(s.charAt(i) == t.charAt(j))
            pick = countWays(i-1, j-1, s, t, dp) % mod;
        notpick = countWays(i-1, j, s, t, dp) % mod;

        return dp[i][j] = (pick + notpick) % mod;
    }

    public static int subsequenceCounting(String s, String t, int n, int m) {
        int[][] dp = new int[n][m];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);
        return countWays(n-1, m-1, s, t, dp);
    }

    // DP
    public static int subsequenceCountingDP(String s, String t, int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int pick = 0, notpick = 0;
                if(s.charAt(i-1) == t.charAt(j-1))
                    pick = dp[i-1][j-1];
                notpick = dp[i-1][j];
                dp[i][j] = (pick + notpick) % mod;
            }
        }

        return dp[n][m];
    }
}
