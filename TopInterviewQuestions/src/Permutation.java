import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(list, new ArrayList<>(), nums);
        return list;
    }

    public static void solve(List<List<Integer>> list, List<Integer> temp, int[] nums) {
        if(temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            solve(list, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(permute(nums));

    }
}
