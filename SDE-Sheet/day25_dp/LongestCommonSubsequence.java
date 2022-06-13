package day25_dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public int longestSub(int i1, int i2, String text1, String text2) {
        if(i1 < 0 || i2 < 0) return 0;

        if(text1.charAt(i1) == text2.charAt(i2)) {
            return 1 + longestSub(i1-1, i2-1, text1, text2);
        }

        int op1 = longestSub(i1-1, i2, text1, text2);
        int op2 = longestSub(i1, i2-1, text1, text2);
        return Math.max(op1, op2);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        return longestSub(n1-1, n2-1, text1, text2);
    }

    // Memoization

    public int longestSubMEM(int i1, int i2, String text1, String text2, int[][] dp) {
        if(i1 < 0 || i2 < 0) return 0;

        if(dp[i1][i2] != -1)
            return dp[i1][i2];

        if(text1.charAt(i1) == text2.charAt(i2)) {
            return dp[i1][i2] = 1 + longestSubMEM(i1-1, i2-1, text1, text2, dp);
        }

        int op1 = longestSubMEM(i1-1, i2, text1, text2, dp);
        int op2 = longestSubMEM(i1, i2-1, text1, text2, dp);
        return dp[i1][i2] = Math.max(op1, op2);
    }

    public int longestCommonSubsequenceMEM(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return longestSubMEM(n1-1, n2-1, text1, text2, dp);
    }

}
