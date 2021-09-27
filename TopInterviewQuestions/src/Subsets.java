import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
//        Arrays.sort(nums); // if nums is not sorted, not required though
        solve(subsets, new ArrayList<>(), nums, 0, nums.length);
        return subsets;
    }

    public static void solve(List<List<Integer>> list, List<Integer> temp, int[] nums, int start, int n) {
        list.add(new ArrayList<>(temp));
        for(int i = start; i < n; i++) {
            temp.add(nums[i]);
            solve(list, temp, nums, i + 1, n);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(subsets(nums));
    }
}
