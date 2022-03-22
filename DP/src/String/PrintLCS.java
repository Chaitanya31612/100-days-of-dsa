package String;

import java.util.Arrays;

public class PrintLCS {
    public static String printlcs(String s, String t) {
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

        for(int[] ar: dp)
            System.out.println(Arrays.toString(ar));
        int i = n-1, j = m-1, k = dp[n-1][m-1] - 1;
        char[] ans = new char[k+1];
        while(i >= 0 && j >= 0) {
            if(s.charAt(i) == t.charAt(j)) {
                ans[k--] = s.charAt(i);
                i--; j--;
            } else {
                if(dp[i][j] == dp[i-1][j]) i--;
                else j--;
            }
        }
        return String.valueOf(ans);
    }
}
