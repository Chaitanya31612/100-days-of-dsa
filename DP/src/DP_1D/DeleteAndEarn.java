package DP_1D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteAndEarn {
    // recursive
    public static int maxEarn(int idx, int sum, int[] nums) {
        //base case
        if(idx == nums.length) {
            return sum;
        }
        if(nums[idx] == 0) {
            return maxEarn(idx+1, sum, nums);
        }

        // recursive case
        int[] delete = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == nums[idx] + 1 || nums[i] == nums[idx] - 1) {
                delete[i] = nums[i];
                nums[i] = 0;
            }
        }

        int pick = maxEarn(idx + 1, sum + nums[idx], nums);
        for(int i = 0; i < nums.length; i++) {
            nums[i] += delete[i];
        }
        int notPick = maxEarn(idx+1, sum, nums);

        return Math.max(pick, notPick);
    }

    // dynamic programming
    public static int maxEarnDP(int[] nums, HashMap<Integer, Integer> map, int maxElement) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        dp.put(1, map.getOrDefault(1, 0));

        for(int i = 2; i <= maxElement; i++) {
            int gain = map.getOrDefault(i, 0);
            int pick = gain + dp.get(i-2);
            int notPick = dp.get(i-1);
            dp.put(i, Math.max(pick, notPick));
        }

        return dp.get(maxElement);
    }

    public static int maxEarnMem(int x, HashMap<Integer, Integer> map, HashMap<Integer, Integer> dp) {
        // base case
        if(x == 0)
            return 0;
        // cannot go beyond 1, so return
        if(x == 1)
            return map.getOrDefault(1, 0);

        if(dp.containsKey(x))
            return dp.get(x);

        // recursive case
        int gain = map.getOrDefault(x, 0);
        int pick = gain + maxEarnMem(x-2, map, dp);
        int notPick = maxEarnMem(x-1, map, dp);

        dp.put(x, Math.max(pick, notPick));
        return dp.get(x);
    }

    public static int deleteAndEarn(int[] nums) {
        // Recursive
//        return maxEarn(0, 0, nums);

        // recursive 2
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + nums[i]);
            max = Math.max(max, nums[i]);
        }
        HashMap<Integer, Integer> dp = new HashMap<>();
//        return maxEarnMem(max, map, dp);

        // dynamic programming
        return maxEarnDP(nums, map, max);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(deleteAndEarn(nums));
    }
}
