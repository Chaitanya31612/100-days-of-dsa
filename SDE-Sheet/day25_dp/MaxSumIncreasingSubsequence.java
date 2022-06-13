package day25_dp;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumIncreasingSubsequence {
    // top down memoization
    public int subSum(int i, int j, int last, int[] arr, int[] sorted, int[][][] dp) {
        int n = arr.length;
        if(i >= n || j >= n) return 0;

        if(dp[i][j][last] != -1)
            return dp[i][j][last];

        if(arr[i] == sorted[j]) {
            dp[i][j][last] = subSum(i+1, j+1, arr[i], arr, sorted, dp);
            if(arr[i] > last) {
                dp[i][j][last] += arr[i];
            }
            return dp[i][j][last];
        }
        int op1 = subSum(i+1, j, last, arr, sorted, dp);
        int op2 = subSum(i, j+1, last, arr, sorted, dp);

        return dp[i][j][last] = Math.max(op1, op2);
    }

    public int maxSumIS(int arr[], int n)
    {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[][][] dp = new int[n][n][sorted[n-1] + 1];
        for(int[][] a: dp)
            for(int[] ar: a)
                Arrays.fill(ar, -1);
        return subSum(0, 0, sorted[0]-1, arr, sorted, dp);
    }


    // bottom up memoization
    public int subSumBU(int i, int j, int last, int[] arr, int[] sorted, int[][][] dp) {
        if(i < 0 || j < 0) return 0;

        if(dp[i][j][last] != -1)
            return dp[i][j][last];

        if(arr[i] == sorted[j]) {
            dp[i][j][last] = subSumBU(i-1, j-1, arr[i], arr, sorted, dp);
            if(arr[i] < last) {
                dp[i][j][last] += arr[i];
            }
            return dp[i][j][last];
        }
        int op1 = subSumBU(i-1, j, last, arr, sorted, dp);
        int op2 = subSumBU(i, j-1, last, arr, sorted, dp);

        return dp[i][j][last] = Math.max(op1, op2);
    }

    public int maxSumISBU(int arr[], int n)
    {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[][][] dp = new int[n][n][sorted[n-1] + 2];
        for(int[][] a: dp)
            for(int[] ar: a)
                Arrays.fill(ar, -1);
        return subSumBU(n-1, n-1, sorted[n-1]+1, arr, sorted, dp);
    }


    // DP solution
    /*
    19 26 32 28 45 18 45 7 38
    7 18 19 26 28 32 38 45 45

    19 26 32 45
    * */

    public int maxSumISDP(int arr[], int n)
    {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[][][] dp = new int[n+1][n+1][sorted[n-1] + 2];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= sorted[n-1]+1; k++) {
                    if(arr[i-1] == sorted[j-1]) {
                        dp[i][j][k] = dp[i-1][j-1][arr[i-1]];
                        if(arr[i-1] < k)
                            dp[i][j][k] += arr[i-1];
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i][j-1][k]);
                    }
                }
            }
        }

//        for(int i = 0; i <= n; i++) {
//            for(int j = 0; j <= n; j++) {
//                for(int k = 0; k <= sorted[n-1]+1; k++) {
//                    System.out.print(dp[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        return dp[n][n][sorted[n-1]+1];
    }

    // accepted solution
    public int maxSumISAcc(int arr[], int n)
    {
        //code here.
        int[] dp =new int[n];
        int max = 0;
        dp[0] = arr[0];
        for(int i=1;i<n;i++)
        {
            max = 0;
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j])
                {
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max + arr[i];
        }
        max = 0;
        for(int i=0;i<n;i++)
        {
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSumIncreasingSubsequence m = new MaxSumIncreasingSubsequence();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(m.maxSumIS(arr, arr.length));
        System.out.println(m.maxSumISBU(arr, arr.length));
        System.out.println(m.maxSumISDP(arr, arr.length));
    }
}
