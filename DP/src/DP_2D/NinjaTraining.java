package DP_2D;

import java.util.Scanner;

//https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003

public class NinjaTraining {
    // recursive method (top down)
    // use top down approach to solve the problem because it becomes easy to translate into dp
    public static int maxCredit(int day, int last, int points[][]) {
        // base case
        if(day == 0) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                if(i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return max;
        }

        // recursive case
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                max = Math.max(max, points[day][i] + maxCredit(day - 1, i, points));
            }
        }
        return max;
    }

    // recursive method (bottom up)
    public static int maxCredit1(int day, int last, int points[][]) {
        // base case
        if(day == points.length - 1) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                if(i != last) {
                    max = Math.max(max, points[day][i]);
                }
            }
            return max;
        }

        // recursive case
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                max = Math.max(max, points[day][i] + maxCredit1(day + 1, i, points));
            }
        }
        return max;
    }

    // memoization method
    public static int maxCreditMem(int day, int last, int points[][], int dp[][]) {
        // base case
        if(day == 0) {
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < 3; i++) {
                if(i != last) {
                    max = Math.max(max, points[0][i]);
                }
            }
            return dp[0][last] = max;
        }

        // recursive case
        if(dp[day][last] != -1) {
            return  dp[day][last];
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++) {
            if(i != last) {
                max = Math.max(max, points[day][i] + maxCreditMem(day - 1, i, points, dp));
            }
        }
        return dp[day][last] = max;
    }

    // DP solution
    public static int maxCreditDP(int n, int[][] points) {
        int[][] dp = new int[n][4];

        // translate base case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // translate recursive case
        for(int day = 1; day < n; day++) {
            for(int last = 0; last < 4; last++) {
                // copy recursive case
                for(int task = 0; task < 3; task++) {
                    if(task != last) {
                        dp[day][last] = Math.max(dp[day][last], points[day][task] + dp[day - 1][task]);
                    }
                }
            }
        }

        // return what is used when calling memozation method
        return dp[n - 1][3];
    }

    public static int ninjaTraining(int n, int points[][]) {
        /*
        * 0 - first activity
        * 1 - second activity
        * 2 - third activity
        * 3 - no activity (initial case)
        * */

        // Method 1 - Recursion
//        return maxCredit(n - 1, 3, points);

        // Methd 2 - Recursion (Bottom Up)
//        return maxCredit1(0, 3, points);

        // Method 3 - Memoization
//        int dp[][] = new int[n][4];
//        for(int[] row : dp) {
//            Arrays.fill(row, -1);
//        }
//        int ans = maxCreditMem(n - 1, 3, points, dp);
//        for(int[] row : dp) {
//            System.out.println(Arrays.toString(row));
//        }
//        return ans;

        // Method 4 - DP
        return maxCreditDP(n, points);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int points[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                points[i][j] = sc.nextInt();
            }
        }

        System.out.println(ninjaTraining(n, points));
    }
}


/*
3
1 2 5
3 1 1
3 3 3
=> 11
* */

/*
3
10 40 70
20 50 80
30 60 90
=> 210
* */