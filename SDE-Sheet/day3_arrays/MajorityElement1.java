package day3_arrays;

import java.util.*;

// https://leetcode.com/problems/majority-element/solution/

public class MajorityElement1 {
  // brute approach use two loops can calculate the count, time - O(n2) space -
  // O(1)

  // good one is to sort the array and analyse that the element whose count is
  // greater than n/2 will be present in the middle, sort return middle element
  // time - O(nlogn) space - O(1)

  // time - O(n) space - O(n)
  public static int majorityElementMap(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (!map.containsKey(nums[i])) {
        map.put(nums[i], 0);
      }
      map.put(nums[i], map.get(nums[i]) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > (nums.length / 2)) {
        return entry.getKey();
      }
    }

    return -1;
  }

  // best approach
  // Moore voting algo
  public static int majorityElement(int[] nums) {
    int count = 0, candidate = 0;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      if (num == candidate) {
        count++;
      } else {
        count--;
      }
    }

    return candidate;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 1, 2, 3, 2 };
    System.out.println(majorityElement(nums));
  }
}
