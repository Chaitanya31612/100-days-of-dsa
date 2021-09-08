import java.util.Arrays;
import java.util.Scanner;

public class SquareSorted {
    public static int[] sortedSquareBetter(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int start = 0, end = n - 1;

        for(int i = n - 1; i >= 0; i--) {
            if((nums[start] * nums[start]) > (nums[end] * nums[end])) {
                ans[i] = nums[start] * nums[start];
                start++;
            } else {
                ans[i] = nums[end] * nums[end];
                end--;
            }
        }

        return ans;
    }

    public static int[] sortedSquaresNaive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

//        System.out.println(Arrays.toString(sortedSquaresNaive(nums)));
        System.out.println(Arrays.toString(sortedSquareBetter(nums)));
    }
}
