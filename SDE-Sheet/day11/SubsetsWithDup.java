package day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums);
        subsetUtil(subsets, new ArrayList<>(), nums, 0, nums.length);
        return subsets;
    }

    public void subsetUtil(List<List<Integer>> list, List<Integer> temp,int[] nums, int start, int n) {
        list.add(new ArrayList<>(temp));
        for(int i = start; i <n; i++) {
            if(i > start && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            subsetUtil(list, temp, nums, i + 1, n);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {

    }
}
