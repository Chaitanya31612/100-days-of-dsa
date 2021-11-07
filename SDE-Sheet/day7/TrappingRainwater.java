package day7;

// https://leetcode.com/problems/trapping-rain-water/discuss/1556570/Java-solution-all-approaches-oror-Brute-to-optimal
public class TrappingRainwater {
    // O(n2) time and O(1) space
    public int trapBrute(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            int j = i, left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
            while(j >= 0) {
                left = Math.max(left, height[j]);
                j--;
            }
            j = i;
            while(j < n) {
                right = Math.max(right, height[j]);
                j++;
            }
            sum += Math.min(left, right) - height[i];
        }

        return sum;
    }

    // prefix sum
    // time - O(1) space - O(n)
    public int trapPrefix(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int sum = 0;
        int[] pre = new int[n];
        pre[0] = height[0];
        for(int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i-1], height[i]);
        }
        int[] suff = new int[n];
        suff[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--) {
            suff[i] = Math.max(suff[i+1], height[i]);
        }
        for(int i = 0; i < n; i++) {
            sum += Math.min(pre[i], suff[i]) - height[i];
        }

        return sum;
    }

    // two pointer approach - best approach
    // time - O(n) space - O(1)
    public int trap(int[] height) {
        int n = height.length;
        if(n <= 2) return 0;
        int sum = 0;

        int l = 0, r = n - 1;
        int leftMax = 0, rightMax = 0;
        while(l < r) {
            if(height[l] <= height[r]) {
                if(height[l] >= leftMax) leftMax = height[l];
                else {
                    sum += leftMax - height[l];
                }
                l++;
            } else {
                if(height[r] >= rightMax) rightMax = height[r];
                else {
                    sum += rightMax - height[r];
                }
                r--;
            }
        }

        return sum;
    }
}
