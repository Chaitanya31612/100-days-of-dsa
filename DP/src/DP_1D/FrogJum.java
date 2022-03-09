package DP_1D;

import java.util.Scanner;

public class FrogJum {
    public static int funRec(int ind, int[] heights) {
        if(ind == 0) return 0;

        int step1 = funRec(ind-1, heights) + Math.abs(heights[ind] - heights[ind-1]);
        int step2 = Integer.MAX_VALUE;
        if(ind > 1)
            step2 = funRec(ind-2, heights) + Math.abs(heights[ind] - heights[ind-2]);

        return Math.min(step1, step2);
    }

    public static int frogJumpRec(int n, int heights[]) {
        return funRec(n-1, heights);
    }


    // tabulation
    public static int fun(int ind, int[] heights) {
        int[] dp = new int[ind + 1];
        dp[0] = 0;
        for(int i = 1; i <= ind; i++) {
            int step1 = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int step2 = Integer.MAX_VALUE;
            if(i > 1)
                step2 = dp[i-2] + Math.abs(heights[i] - heights[i-2]);

            dp[i] = Math.min(step1, step2);
        }

        return dp[ind];
    }

    public static int frogJump(int n, int heights[]) {
        return fun(n-1, heights);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++)
            heights[i] = sc.nextInt();
        System.out.println(frogJump(n, heights));
    }
}
