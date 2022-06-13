package String;

public class LongestCommonSubstring {
    public String f(int i, int j, String s1, String s2, String sub) {
        if(i < 0 || j < 0) return "";

        if(s1.charAt(i) == s2.charAt(j)) {
            return f(i-1, j-1, s1, s2, s1.substring(i,i+1) + sub);
        }
        String op1 = f(i-1, j, s1, s2, "");
        String op2 = f(i, j-1, s1, s2, "");
        if(op1.length() >= op2.length() && sub.length() <= op1.length()) sub = op1;
        else if(op1.length() < op2.length() && sub.length() <= op2.length()) sub = op2;
        return sub;
    }

    public String longestCommonSubstring(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return f(s.length()-1, s.length()-1, s, sb.toString(), "");
    }


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
