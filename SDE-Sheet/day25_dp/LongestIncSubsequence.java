package day25_dp;

import java.util.HashMap;

public class LongestIncSubsequence {
    // recursive approach
    public int longestLength(int idx, int last, int[] nums) {
        if(idx == 0) {
            if(nums[idx] < last) return 1;
            return 0;
        }

        int notpick = longestLength(idx-1, last, nums);
        int pick = 0;
        if(nums[idx] < last)
            pick = 1 + longestLength(idx-1, nums[idx], nums);

        return Math.max(notpick, pick);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;

        return longestLength(n-1, Integer.MAX_VALUE, nums);

    }


    // memoization
    public int longestLengthMem(int idx, int last, int[] nums, HashMap<String,Integer> dp) {
        if(idx == 0) {
            if(nums[idx] < last) return 1;
            return 0;
        }

        String check = idx + "" + last;
        if(dp.containsKey(check))
            return dp.get(check);

        int notpick = longestLengthMem(idx-1, last, nums, dp);
        int pick = 0;
        if(nums[idx] < last)
            pick = 1 + longestLengthMem(idx-1, nums[idx], nums, dp);

        dp.put(check, Math.max(notpick, pick));
        return dp.get(check);
    }

    public int lengthOfLISMem(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        for(int el: nums) max = Math.max(max, el);
        HashMap<String, Integer> dp = new HashMap<>();
        return longestLengthMem(n-1, max+1, nums, dp);
    }
}
