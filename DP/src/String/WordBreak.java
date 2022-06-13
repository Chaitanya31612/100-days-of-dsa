package String;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean f(int i, int j, String s, List<String> wordDict, int[][] dp) {
        if(j == s.length()-1) {
            if(wordDict.contains(s.substring(i))) {
                dp[i][j] = 1;
                return true;
            }
            dp[i][j] = 0;
            return false;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1 ? true : false;;

        boolean take = false, nottake = false;
        if(wordDict.contains(s.substring(i, j+1))) {
            take = f(j+1, j+1, s, wordDict, dp);
        }
        nottake = f(i, j+1, s, wordDict, dp);
        dp[i][j] = take || nottake ? 1 : 0;
        return take || nottake;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);
        return f(0, 0, s, wordDict, dp);
    }

    // DP
    public boolean wordBreakDP(String s, List<String> wordDict) {
        int n = s.length();
        if(wordDict.contains(s)) return true;
        boolean[][] dp = new boolean[n+1][n+1];

        for(int i = 0; i < n; i++)
            if(wordDict.contains(s.substring(i)))
                dp[i][n] = true;

        for(int i = n-1; i >= 0; i--) {
            for(int j = n-1; j >= i; j--) {
                if(wordDict.contains(s.substring(i, j+1)) && dp[j+1][j+1]) {
                    dp[i][j] = true;
                } else if(dp[i][j+1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;;
                }
            }
        }

        return dp[0][0];
    }
}
