package String;

public class MinInsertionPalindrome {
    public static int lcs(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1;
                    if(i > 0 && j > 0)
                        dp[i][j] += dp[i-1][j-1];
                } else {
                    int op1 = 0, op2 = 0;
                    if(i>0) op1 = dp[i-1][j];
                    if(j>0) op2 = dp[i][j-1];
                    dp[i][j] = Math.max(op1, op2);
                }
            }
        }
        return dp[n-1][m-1];
    }

    // find lcs of string and its reverse, and return the length of lcs
    public static int longestPalindromeSubsequence(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return lcs(s, sb.toString());
    }

    // n - length of longest palindromic subsequence
    public static int minInsertion(String str) {
        return str.length() - longestPalindromeSubsequence(str);
    }
}
