public class TrappingRainWater {
    // https://leetcode.com/problems/trapping-rain-water/

    // brute force O(N^2)
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        for(int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;
            for(int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, height[j]);
            for(int j = i; j < n; j++)
                rightMax = Math.max(rightMax, height[j]);

            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }

    // DP
    public int trapDP(int[] height) {
        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        leftMax[0] = height[0];
        for(int i = 1; i < n; i++) leftMax[i] = Math.max(leftMax[i-1], height[i]);

        rightMax[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) rightMax[i] = Math.max(rightMax[i+1], height[i]);

        for(int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
