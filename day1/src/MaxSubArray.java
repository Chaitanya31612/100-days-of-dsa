import java.util.Scanner;

public class MaxSubArray {
    public static int maxSubArrayBruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            max = Math.max(max, curr);
            for(int j = i + 1; j < n; j++) {
                curr += nums[j];
                max = Math.max(max, curr);
            }
        }

        return max;
    }

    public static int maxSubArrayKadane(int[] nums) {
        int max = Integer.MIN_VALUE, curr = 0;

        for (int num : nums) {
            curr += num;

            max = Math.max(max, curr);
            if (curr < 0) {
                curr = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(maxSubArrayBruteForce(nums));
    }
}

/*
9
-2 1 -3 4 -1 2 1 -5 4

> 6
* */