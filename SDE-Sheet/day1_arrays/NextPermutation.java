package day1_arrays;

import java.util.*;

// https://leetcode.com/problems/next-permutation/discuss/1528421/Java-Solution-with-explanation

public class NextPermutation {

  public static void nextPermutation(int[] nums) {
    int n = nums.length;
    // boolean flag = false;
    int i;
    for (i = n - 1; i >= 1; i--) {
      if (nums[i] > nums[i - 1]) {
        // flag = true;
        int min = Integer.MAX_VALUE, minIdx = -1;
        for (int j = i + 1; j < n; j++) {
          if (nums[j] < min && nums[j] > nums[i - 1]) {
            min = nums[j];
            minIdx = j;
          }
        }
        if (minIdx == -1) {
          int temp = nums[i];
          nums[i] = nums[i - 1];
          nums[i - 1] = temp;
        } else {
          int temp = nums[i - 1];
          nums[i - 1] = nums[minIdx];
          nums[minIdx] = temp;
        }

        // int s = i, e = n - 1, temp;
        // while (s < e) {
        // temp = nums[s];
        // nums[s++] = nums[e];
        // nums[e--] = temp;
        // }

        // Arrays.sort(nums, i, n);
        break;
      }
    }
    Arrays.sort(nums, i, n);
    // if (!flag) {
    // Arrays.sort(nums);
    // }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] nums = new int[n];

    for (int i = 0; i < n; i++)
      nums[i] = sc.nextInt();

    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
    sc.close();
  }
}
