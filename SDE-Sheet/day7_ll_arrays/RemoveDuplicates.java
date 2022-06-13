package day7_ll_arrays;

import java.util.TreeSet;

public class RemoveDuplicates {
    public int removeDuplicatesBrute(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        int n = nums.length;
        for (int num : nums) {
            set.add(num);
        }
        int k = 0;
        for(int el : set) {
            nums[k++] = el;
        }

        return k;
    }

    
}
