package String;

import java.util.Arrays;
//https://www.codingninjas.com/codestudio/problems/edit-distance_630420
public class EditDistance {
    public static int minSteps(int i, int j, String s, String t, int[][] dp) {
        if(i == 0 && j == 0)
            return (s.charAt(0) == t.charAt(0)) ? 0 : 1;
        if(j < 0) return i+1;
        if(i < 0) return j+1;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            return minSteps(i-1, j-1, s, t, dp);
        }
        int ins = 1 + minSteps(i, j-1, s, t, dp);
        int rem = 1 + minSteps(i-1, j, s, t, dp);
        int rep = 1 + minSteps(i-1, j-1, s, t, dp);
        return dp[i][j] = Math.min(ins, Math.min(rem, rep));
    }

    public static int editDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);
        return minSteps(n-1, m-1, s, t, dp);
    }


    // DP
    public static int editDistanceDP(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) dp[i][0] = i;
        for(int j = 1; j <= m; j++) dp[0][j] = j;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int ins = 1 + dp[i][j-1];
                    int rem = 1 + dp[i-1][j];
                    int rep = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(ins, Math.min(rem, rep));
                }
            }
        }
        return dp[n][m];
    }
}
