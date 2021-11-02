package day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/discuss/1555028/Java-easy-solution-oror-Brute-and-Optimised
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int i = 0, j, n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        if(n < 3) return list;
        // sort the array
        Arrays.sort(nums);
        // fix one element
        while(i < n) {
            // make use of left and right pointer for finding sum keeping in mind that array is sorted
            int left = i + 1, right = n - 1;
            int target = -1 * (nums[i]);

            while(left < right) {
                if(nums[left] + nums[right] < target) left++;
                else if(nums[left] + nums[right] > target) right--;
                    // if the sum is equal to target than add in list
                else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    list.add(l);

                    // pass over duplicates
                    int leftEl = nums[left];
                    while(left < right && leftEl == nums[left]) left++;
                    // pass over duplicates
                    int rightEl = nums[right];
                    while(right > left && rightEl == nums[right]) right--;
                }
            }
            // pass over duplicates
            int ithEl = nums[i];
            while(i < n && nums[i] == ithEl) i++;
        }

        return list;
    }

    public List<List<Integer>> threeSumBrute(int[] nums) {
        int i = 0, j, n = nums.length;
        List<List<Integer>> list = new ArrayList<>();

        if(n < 3) return list;
        Arrays.sort(nums);
        while(i < n) {
            j = i + 1;
            while(j < n) {
                int target = -1 * (nums[i] + nums[j]);

                int s = j + 1, e = n - 1;
                while(s <= e) {
                    int mid = (s + e) / 2;
                    if(nums[mid] == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[mid]);
                        list.add(l);
                        break;
                    } else if(target < nums[mid]) {
                        e = mid - 1;
                    } else {
                        s = mid + 1;
                    }
                }
                int jthEl = nums[j];
                while(j < n && nums[j] == jthEl) j++;
            }
            int ithEl = nums[i];
            while(i < n && nums[i] == ithEl) i++;
        }

        return list;
    }
}
