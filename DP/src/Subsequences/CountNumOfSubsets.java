package Subsequences;

import java.util.Arrays;
// https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
public class CountNumOfSubsets {
    public static int countWays(int idx, int[] num, int target, int[][] dp) {
        if(target == 0) return 1;
        if(idx == 0) return (num[0] == target) ? 1 : 0;

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int notPickWays = countWays(idx-1, num, target, dp);
        int pickWays = 0;
        if(num[idx] <= target) {
            pickWays = countWays(idx-1, num, target-num[idx], dp);
        }

        return dp[idx][target] = notPickWays + pickWays;
    }

    public static int countWaysDP(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int i = 0; i < n; i++)
            dp[i][0] = 1;
        if(num[0] <= tar) dp[0][num[0]] = 1;

        for(int i = 1; i < n; i++){
            for(int target = 1; target <= tar; target++) {
                int notPickWays = dp[i-1][target];
                int pickWays = 0;
                if(num[i] <= target)
                    pickWays = dp[i-1][target-num[i]];
                dp[i][target] = notPickWays + pickWays;
            }
        }

        return dp[n-1][tar];
    }

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int[] arr: dp)
            Arrays.fill(arr, -1);
        return countWays(n-1, num, tar, dp);
    }

    public static void main(String[] args) {
        int num[] = {0,13,18,14,15,19,21,2,8,1};
        int tar = 75;
        System.out.println(findWays(num, tar));
        System.out.println(countWaysDP(num, tar));
    }
}