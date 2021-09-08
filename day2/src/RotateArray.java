import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {

    // better solution (naive would be to move k time and shift k times)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int kmod = k % n;

        if(kmod == 0)
            return;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = n - kmod; i < n; i++) {
            list.add(nums[i]);
        }

        for(int i = 0; i < n - kmod; i++) {
            list.add(nums[i]);
        }

        for(int i = 0; i < n; i++) {
            nums[i] = list.get(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = sc.nextInt();

        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
}
