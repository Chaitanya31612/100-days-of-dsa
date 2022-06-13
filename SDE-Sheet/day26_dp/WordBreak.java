package day26_dp;

import java.util.ArrayList;

public class WordBreak {
    public static int wordBreak(String A, ArrayList<String> B)
    {
        int n = A.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if(B.contains(A.substring(j, i+1))) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
