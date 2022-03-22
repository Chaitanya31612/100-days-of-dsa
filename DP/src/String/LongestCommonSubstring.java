package String;

public class LongestCommonSubstring {
    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1;
                    if(i > 0 && j > 0)
                        dp[i][j] += dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
