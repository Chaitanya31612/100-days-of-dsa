package Subsequences;

import java.util.Arrays;

public class CountWaysMakeChange {
    public static long countWays(int ind, int target, int[] arr, long[][] dp) {
        if(ind == 0) {
            if(target % arr[ind] == 0) return 1;
            return 0;
        }

        if(dp[ind][target] != -1)
            return dp[ind][target];

        long notpick = countWays(ind-1, target, arr, dp);
        long pick = 0;
        if(arr[ind] <= target)
            pick = countWays(ind, target-arr[ind], arr, dp);

        return dp[ind][target] = notpick + pick;
    }

    public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        long[][] dp = new long[n][value+1];
        for(long[] ar: dp)
            Arrays.fill(ar, -1);

        return countWays(n-1, value, denominations, dp);
    }

    // DP
    public static long countWaysToMakeChangeDP(int[] arr, int value){
        int n = arr.length;
        long[][] dp = new long[n][value+1];

        for(int k = 0; k <= value; k++) {
            if(k % arr[0] == 0) {
                dp[0][k] = 1;
            }
        }

        for(int ind = 1; ind < n; ind++) {
            for(int target = 0; target <= value; target++) {
                long notpick = dp[ind-1][target];
                long pick = 0;
                if(arr[ind] <= target)
                    pick = dp[ind][target-arr[ind]];
                dp[ind][target] = notpick + pick;
            }
        }

        return dp[n-1][value];
    }
}
