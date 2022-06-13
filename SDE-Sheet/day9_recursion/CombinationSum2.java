package day9_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/discuss/1560743/Java-easy-solution-with-explanation-oror-Recursion-and-backtracking

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        combinationUtil(list, new ArrayList<>(), candidates, 0, target);
        return list;
    }

    public void combinationUtil(List<List<Integer>> list, List<Integer> temp, int[] candidates, int start, int target) {
        // base case
        if(target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }

        // recursive step
        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(target < candidates[i]) return;

            temp.add(candidates[i]);
            combinationUtil(list, temp, candidates, i + 1, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }
}
