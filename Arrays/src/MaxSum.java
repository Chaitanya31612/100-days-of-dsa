import java.util.Scanner;

public class MaxSum {
    // initial - brute force n2
    public static int max_sumInitial(int[] arr, int n) {
        int maxSum = Integer.MIN_VALUE;
        for(int c = 0; c < n; c++) {
            int currSum = 0;
            int m = 0;
            for(int i = c; i < n; i++) {
                currSum += arr[i] * m;
                m++;
            }

            for(int i = 0; i < c; i++) {
                currSum += arr[i] * m;
                m++;
            }
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    // optimal solution - build solution from previous one
    public static int max_sum(int[] arr, int n) {
        int[] S = new int[n];
        int sum = 0; // for increasing the count index
        for(int i = 0; i < n; i++) {
            sum += arr[i];
            S[0] += arr[i] * i;
        }

        int max = S[0];
        for(int i = 0; i < n - 1; i++) {
            S[i + 1] = S[i] + sum - n * arr[n - i - 1];
            if(S[i + 1] > max) {
                max = S[i + 1];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(max_sum(arr, n));
    }
}
