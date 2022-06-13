package day1_arrays;

public class Kadane {
  public int maxSubArray(int[] nums) {
    int maxSum = Integer.MIN_VALUE, curSum = 0;

    for (int i = 0; i < nums.length; i++) {
      curSum += nums[i];
      if (curSum > maxSum)
        maxSum = curSum;

      if (curSum < 0)
        curSum = 0;
    }

    return maxSum;
  }

  public static void main(String[] args) {

  }
}
