package Subsequences;

public class TargetSum {
    public static int numWays(int idx, int target, int[] arr) {
        // base case
        if(idx == 0) {
            // calculate sum and return 1 if equal to target
            int sum1 = 0;
            for(int el: arr)
                sum1 += el;
            int sum2 = sum1 - arr[0] + (-arr[0]);
            if(sum1 == target && sum2 == target) return 2;
            if(sum1 == target || sum2 == target) return 1;
            return 0;
        }

        // recursive case
        arr[idx] = -arr[idx];
        int neg = numWays(idx-1, target, arr);
        arr[idx] = -arr[idx];
        int plus = numWays(idx-1, target, arr);
        return neg + plus;
    }

    public static int targetSum(int n, int target, int[] arr) {
        return numWays(n-1, target, arr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        int n = arr.length;
        System.out.println(targetSum(n, target, arr));
    }
}
