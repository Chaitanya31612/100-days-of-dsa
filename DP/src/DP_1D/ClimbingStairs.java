package DP_1D;

import java.util.Scanner;

public class ClimbingStairs {
    // need to reach to top choices are - 1 step or 2 step
    // goal is to count number of steps to reach final stair
    public static int countWays(int ind) {
        // base case
        // only one way if on final stair or on n-1 stair
        if(ind == 0 || ind == 1) return 1;
        else if(ind < 0) return 0;

        int step1 = countWays(ind - 1);
        int step2 = countWays(ind - 2);
        return step1 + step2;
    }

    public int climbStairs(int n) {
        if(n == 0 || n == 1) return 1;

        int prev2 = 1, prev = 1, curr = 0;

        for(int i = 2; i <= n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countWays(n));
    }
}
