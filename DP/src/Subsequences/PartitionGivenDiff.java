package Subsequences;

import java.util.Arrays;

public class PartitionGivenDiff {
    static int mod = (int)(1e9 + 7);
    public static int countWays(int idx, int[] arr, int target, int[][] dp) {
        if(idx == 0) {
            if(target == 0 && arr[idx] == 0) return 2;
            if(target == 0 || arr[0] == target) return 1;
            else return 0;
        }

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int nottake = countWays(idx-1, arr, target, dp);
        int take = 0;
        if(arr[idx] <= target)
            take = countWays(idx-1, arr, target-arr[idx], dp);

        return dp[idx][target] = (nottake + take) % mod;
    }

    public static int findWays(int[] arr, int n, int target) {
        int[][] dp = new int[n][target+1];
        dp[0][0] = 1;
        if(arr[0] == 0) {
            dp[0][0] = 2;
        }
        if(arr[0] > 0 && arr[0] <= target) dp[0][arr[0]] = 1;


        for(int i = 1; i < n; i++) {
            for(int k = 0; k <= target; k++) {
                int nottake = dp[i-1][k];
                int take = 0;
                if(arr[i] <= k)
                    take = dp[i-1][k-arr[i]];
                dp[i][k] = (nottake + take) % mod;
            }
        }

        return (dp[n-1][target]) % mod;
    }
    public static int countPartitions(int n, int d, int[] arr) {
        int totalsum = 0;
        for(int el: arr)
            totalsum += el;

        if(totalsum - d < 0 || ((totalsum-d)&1) == 1) return 0;
//        int t = (totalsum-d)/2;
//        int[][] dp = new int[n][t+1];
//        for(int[] a: dp)
//            Arrays.fill(a, -1);
//        return countWays(n-1, t, arr, dp);
        return findWays(arr, n, (totalsum-d)/2);
    }
}
