package day4_arrays;

import java.util.*;

// https://leetcode.com/problems/4sum/discuss/1536312/Java-easy-solution-with-explanation-oror-Sorting-approach-optimised

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();

        // sort the array first of all
        Arrays.sort(nums);

        int i = 0, j, n = nums.length;
        while (i < n) {
            j = i + 1;
            while (j < n) {
                int left = j + 1, right = n - 1, rem = target - (nums[i] + nums[j]);
                while (left < right) {
                    if (nums[left] + nums[right] == rem) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        list.add(l);

                        // update left
                        int leftEl = nums[left];
                        while (left < right && nums[left] == leftEl)
                            left++;

                        // update right
                        int rightEl = nums[right];
                        while (right > left && nums[right] == rightEl)
                            right--;

                    } else if (nums[left] + nums[right] < rem) {
                        // increment left pointer by jumping over duplicates
                        int leftEl = nums[left];
                        while (left < right && nums[left] == leftEl)
                            left++;
                    } else {
                        // decrement the right pointer by jumping over duplicates
                        int rightEl = nums[right];
                        while (right > left && nums[right] == rightEl)
                            right--;
                    }
                }

                // update j
                int jthEl = nums[j];
                while (j < n && jthEl == nums[j])
                    j++;
            }
            // update i
            int ithEl = nums[i];
            while (i < n && ithEl == nums[i])
                i++;
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        FourSum f = new FourSum();
        System.out.println(f.fourSum(nums, target));
    }
}
