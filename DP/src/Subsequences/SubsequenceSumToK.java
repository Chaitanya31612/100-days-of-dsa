package Subsequences;

import java.util.Arrays;

public class SubsequenceSumToK {
    public static boolean sumToK(int ind, int target, int[] arr, int[][] dp) {
        // base case
        if(target == 0) return true;
        if(ind == 0) return (arr[ind] == target);

        if(dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean notTake = sumToK(ind-1, target, arr, dp);
        boolean take = false;
        if(arr[ind] <= target)
            take = sumToK(ind-1, target-arr[ind], arr, dp);

        dp[ind][target] = (notTake || take ? 1 : 0);
        return notTake || take;
    }
    public static boolean subsetSumToKMem(int n, int k, int[] arr){
        int[][] dp = new int[n][k+1];
        for(int[] a: dp)
            Arrays.fill(a, -1);
        return sumToK(n-1, k, arr, dp);
    }

    public static boolean subsetSumToKDP(int n, int k, int[] arr){
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int ind = 1; ind < n; ind++) {
            for(int target = 1; target <= k; target++) {
                boolean notTake = dp[ind-1][target];
                boolean take = false;
                if(arr[ind] <= target)
                    take = dp[ind-1][target - arr[ind]];
                dp[ind][target] = notTake || take;
            }
        }
        return dp[n-1][k];
    }
}
