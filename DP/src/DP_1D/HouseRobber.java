package DP_1D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// https://www.codingninjas.com/codestudio/problems/house-robber_839733?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

public class HouseRobber {

    public static long maxAmount(int idx, int[] valueInHouse, int n, long[] dp) {
        // base case
        if(idx == n-1)
                return valueInHouse[idx];
        if(idx >= n)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        // recursive case
        long pick = valueInHouse[idx] + maxAmount(idx + 2, valueInHouse, n, dp);
        long notPick = maxAmount(idx + 1, valueInHouse, n, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;

        if(n == 1) return valueInHouse[0];

        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        long ans1 = maxAmount(0, valueInHouse, n-1, dp);
        Arrays.fill(dp, -1);
        long ans2 = maxAmount(1, valueInHouse, n, dp);

        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] valueInHouse = new int[n];
        for(int i = 0; i < n; i++) {
            valueInHouse[i] = sc.nextInt();
        }

        System.out.println(houseRobber(valueInHouse));
    }
}
