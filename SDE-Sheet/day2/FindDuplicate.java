package day2;

import java.util.*;

public class FindDuplicate {
  // first approach is to use another array or hashmap to store the frequency of
  // element, then traverse in that and find

  // hashset can also be used to find duplicate element

  // second would be to sort the array and find two consecutive integers

  // third way is to use negative indexing technique
  public static int findDuplicate(int[] nums) {
    int n = nums.length;

    int dup = -1;

    for (int i = 0; i < n; i++) {
      int curr = Math.abs(nums[i]);
      if (nums[curr] < 0) {
        dup = curr;
        break;
      } else {
        nums[curr] *= -1;
      }
    }

    return dup;
  }

  // floyd tortoise and hare method
  // https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2
  public static int findDuplicateOptimal(int[] nums) {
    // initialise the slow and fast pointer to nums[0]
    int slow = nums[0], fast = nums[0];

    // move slow pointer by 1 and fast pointer by 2 until they meet at a point
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    // after slow and fast have met set fast pointer to nums[0], and it is
    // guarenteed that the number of steps now moved by slow will be equal to fast
    fast = nums[0];
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    // the answer is either slow or fast
    return slow;
  }

  public static void main(String[] args) {

  }
}