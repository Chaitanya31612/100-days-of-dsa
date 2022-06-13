package day10_recursion_backtracking;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/permutations/discuss/1564505/Java-easy-solution-oror-Recursion-and-backtracking
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permuteUtil(list, new ArrayList<>(), nums);
        return list;
    }

    public void permuteUtil(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        //base case
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        //recursive case
        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            permuteUtil(list, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
