package Subsequences;

public class PartitionSubsetMin {
    public static int minSubsetSumDifference(int[] arr, int n) {
        int total = 0;
        for (int j : arr) total += j;

        boolean[][] dp = new boolean[n][total+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= total) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int k = 1; k <= total; k++) {
                boolean notTake = dp[i-1][k];
                boolean take = false;
                if(arr[i] <= k)
                    take = dp[i-1][k-arr[i]];
                dp[i][k] = notTake || take;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= total/2; i++) {
            if(dp[n-1][i])
                min = Math.min(min, ((total - i) - i));
        }
        return min;
    }
}
