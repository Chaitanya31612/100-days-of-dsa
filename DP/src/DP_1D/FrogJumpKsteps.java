package DP_1D;

public class FrogJumpKsteps {

    public static int frogJump(int n, int k, int[] heights) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                int jumpEnergy = frogJump(i-j, k, heights) + Math.abs(heights[i] - heights[i-j]);
                minSteps = Math.min(jumpEnergy, minSteps);
            }
            dp[i] = minSteps;
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
