package String;

import java.util.Arrays;
import java.util.HashSet;

public class DecodeWays {
    public int f(int i, int j, String s, HashSet<String> set, int[][] dp) {
        // base case
        if(j == s.length()) {
            if(set.contains(s.substring(i))) return 1;
            else return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        int pick = 0;
        if(set.contains(s.substring(i, j+1))) {
            pick = f(j+1, j+1, s, set, dp);
        }
        int notpick = f(i, j+1, s, set, dp);
        return dp[i][j] = pick + notpick;
    }

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        HashSet<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++)
            set.add(String.valueOf(i));
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);
        return f(0, 0, s, set, dp);
    }

    // DP
    public int numDecodingsDP(String s) {
        if(s.charAt(0) == '0') return 0;

        HashSet<String> set = new HashSet<>();
        for(int i = 1; i <= 26; i++)
            set.add(String.valueOf(i));

        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i < n; i++) {
            if(set.contains(s.substring(i))) dp[i][n] = 1;
            else dp[i][n] = 0;
        }

        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= i; j--) {
                int pick = 0;
                if(set.contains(s.substring(i, j+1)))
                    pick = dp[j+1][j+1];
                int notpick = dp[i][j+1];
                dp[i][j] = pick + notpick;
            }
        }

        return dp[0][0];
    }
}
