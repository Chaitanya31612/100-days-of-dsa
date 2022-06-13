package Subsequences;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    // binary search approach
    public int findIdx(ArrayList<Integer> nums, int target) {
        int s = 0, e = nums.size()-1;
        while(s < e) {
            int mid = s + (e-s)/2;
            if(nums.get(mid) == target) return mid;
            else if(target < nums.get(mid)) e = mid;
            else s = mid+1;
        }

        return e;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] > temp.get(temp.size()-1)) {
                temp.add(nums[i]);
                len++;
            } else {
                int idx = findIdx(temp, nums[i]);
                temp.set(idx, nums[i]);
            }
        }
        return len;
    }

    // memoization approach
    public int f(int i, int lastIdx, int[] nums, int[][] dp) {
        if(i == nums.length) return 0;

        if(dp[i][lastIdx+1] != -1) return dp[i][lastIdx+1];

        int pick = 0;
        if(lastIdx == -1 || nums[i] > nums[lastIdx]) {
            pick = f(i+1, i, nums, dp) + 1;
        }
        int notpick = f(i+1, lastIdx, nums, dp);
        return dp[i][lastIdx+1] = Math.max(pick, notpick);
    }

    public int lengthOfLISMem(int[] nums) {
        int n = nums.length;
        // n+1 is done for coordinate change, we cannot store -1 for lastIdx so we do lastIdx+1
        int[][] dp = new int[n][n+1];
        for(int[] ar: dp)
            Arrays.fill(ar, -1);
        return f(0, -1, nums, dp);
    }

    // dp approach
    public int lengthOfLISDP(int[] nums) {
        int n = nums.length;
        // n+1 is done for coordinate change, we cannot store -1 for lastIdx so we do lastIdx+1
        int[][] dp = new int[n+1][n+1];

        // i -> n-1 to 0
        // lastIdx -> i-1 to 0

        for(int i = n-1; i >= 0; i--) {
            for(int lastIdx = i-1; lastIdx >= -1; lastIdx--) {
                int pick = 0;
                if(lastIdx == -1 || nums[i] > nums[lastIdx]) {
                    pick = dp[i+1][i+1] + 1;
                }
                int notpick = dp[i+1][lastIdx+1];
                dp[i][lastIdx+1] = Math.max(pick, notpick);
            }
        }

        return dp[0][0];
    }
}
