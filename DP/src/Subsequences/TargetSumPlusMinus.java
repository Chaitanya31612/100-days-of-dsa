package Subsequences;

public class TargetSumPlusMinus {
    public static int countWays(int idx, int target, int[] arr, int[][] dp) {
        if(idx == 0) {
            if(target == 0 && arr[0] == 0) return 2;
            if(target == 0 || arr[idx] == target) return 1;
            return 0;
        }

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int notpick = countWays(idx-1, target, arr, dp);
        int pick = 0;
        if(arr[idx] <= target)
            pick = countWays(idx-1, target-arr[idx], arr, dp);

        return dp[idx][target] = notpick + pick;
    }
    public static int countWays(int[] arr, int n, int target) {
        int[][] dp = new int[n][target+1];

        dp[0][0] = 1;
        if(arr[0] == 0)
            dp[0][0] = 2;

        else if(arr[0] <= target) dp[0][arr[0]] = 1;

        for(int i = 1; i < n; i++) {
            for(int k = 0; k <= target; k++) {
                int notpick = dp[i-1][k];
                int pick = 0;
                if(arr[i] <= k)
                    pick = dp[i-1][k-arr[i]];
                dp[i][k] = notpick + pick;
            }
        }
        return dp[n-1][target];
    }
    public static int targetSum(int n, int target, int[] arr) {
        int sum = 0;
        for(int el: arr)
            sum += el;
        if((sum - target) < 0 || (sum - target) % 2 == 1) return 0;
        int t = (sum-target)/2;
//         int[][] dp = new int[n][t+1];
//         for(int[] a: dp)
//             Arrays.fill(a, -1);
//         return countWays(n-1, t, arr, dp);
        return countWays(arr, n, t);
    }
}
