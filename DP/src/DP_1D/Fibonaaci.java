package DP_1D;

import java.util.Scanner;

public class Fibonaaci {

    // dp
    public static int fibdp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[n];
    }

    // dp with space optimisation
    public static int fib(int n) {
        if(n <= 1) return n;

        int prev2 = 0, prev = 1, curr = 0;
        for(int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        // both curr and prev store same value
        System.out.println("prev = " + prev);
        System.out.println("curr = " + curr);
        return prev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibdp(n));
        System.out.println(fib(n));

    }
}
