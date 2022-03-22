package String;

import java.util.Arrays;

public class LCS {
    // longest common subsequence
    public static int maxLength(int i1, int i2, String s, String t, int[][] dp) {
        if(i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2] != -1)
            return dp[i1][i2];

        if(s.charAt(i1) == t.charAt(i2)) {
            return dp[i1][i2] = 1 + maxLength(i1-1, i2-1, s, t, dp);
        }
        int op1 = maxLength(i1-1, i2, s, t, dp);
        int op2 = maxLength(i1, i2-1, s, t, dp);
        return dp[i1][i2] = Math.max(op1, op2);
    }
    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);

        return maxLength(n-1, m-1, s, t, dp);
    }

    public static int lcsDP(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];

        for(int i1 = 0; i1 < n; i1++) {
            for(int i2 = 0; i2 < m; i2++) {
                if(s.charAt(i1) == t.charAt(i2)) {
                    dp[i1][i2] = 1;
                    if(i1 > 0 && i2 > 0)
                        dp[i1][i2] += dp[i1-1][i2-1];
                } else {
                    int op1=0, op2=0;
                    if(i1>0) op1 = dp[i1-1][i2];
                    if(i2>0) op2 = dp[i1][i2-1];
                    dp[i1][i2] = Math.max(op1, op2);
                }
            }
        }

        return dp[n-1][m-1];
    }
}