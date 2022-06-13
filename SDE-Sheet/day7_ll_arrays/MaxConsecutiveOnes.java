package day7_ll_arrays;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0, maxCount = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            currCount++;

            if(nums[i] != 1)
                currCount = 0;

            maxCount = Math.max(maxCount, currCount);
        }

        return maxCount;
    }
}
