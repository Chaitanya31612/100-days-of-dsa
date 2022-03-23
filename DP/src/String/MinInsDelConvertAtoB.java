package String;

public class MinInsDelConvertAtoB {
    public static int lcs(String s, String t) {
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

    public static int canYouMake(String str, String ptr) {
        int common = lcs(str, ptr);
        return (str.length() - common) + (ptr.length() - common);
    }
}
