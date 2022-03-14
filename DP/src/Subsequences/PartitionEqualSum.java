package Subsequences;

import java.util.Scanner;

public class PartitionEqualSum {
    public static boolean sumSubsK(int[] arr, int n, int target) {
        boolean[][] dp = new boolean[n][target+1];
        for(int i = 0; i < n; i++) dp[i][0] = true;
        if(arr[0] <= target) dp[0][arr[0]] = true;

        for(int i = 1; i < n; i++) {
            for(int k = 1; k <= target; k++) {
                boolean notTake = dp[i-1][k];
                boolean take = false;
                if(arr[i] <= k)
                    take = dp[i-1][k-arr[i]];
                dp[i][k] = notTake || take;
            }
        }

        return dp[n-1][target];
    }

    public static boolean canPartition(int[] arr, int n) {
        int totSum = 0;
        for(int i = 0; i < arr.length; i++)
            totSum += arr[i];

        if((totSum&1) == 1) return false;
        int target = totSum/2;
        return sumSubsK(arr, n, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(canPartition(arr, n));
    }
}
