import java.util.Scanner;

public class MaxProductSubarray {
    // incorrect - way of thinking
    public static long maxProductInitial(int[] arr, int n) {
        long zeros = 0, neg = 0, minNeg = Long.MAX_VALUE, prod = 1;
        long max = Long.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 0) {
                long curr = prod;
                if(neg % 2 != 0) {
                    curr = curr / minNeg;
                }
                if(curr > max)
                    max = curr;
                prod = 1; minNeg = Integer.MAX_VALUE; neg = 0;
                zeros++;
                continue;
            }
            if(arr[i] < 0) {
                if(Math.abs(arr[i]) < Math.abs(minNeg))
                    minNeg = arr[i];
                neg++;
            }
            prod *= arr[i];
            if(i == n - 1) {
                if(prod > max)
                    max = prod;
            }
        }

        if(zeros == n)
            return 0;
        return max;
    }

    /*
    * https://www.youtube.com/watch?v=jzQ-f2uU0UU
    * the assumption is that there are two possibilities for the ans, either subarray is from the start or from the end and no where in the middle
    * */
    /* similar to kadane's algorithm */
    public static long maxProduct(int[] arr, int n) {
        long max = Long.MIN_VALUE;
        long cprod = 1;

        for(int i = 0; i < n; i++) {
            cprod *= arr[i];
            max = Math.max(max, cprod);
            if(arr[i] == 0) {
                cprod = 1;
            }
        }

        cprod = 1;
        for(int i = n - 1; i >= 0; i--) {
            cprod *= arr[i];
            max = Math.max(max, cprod);
            if(arr[i] == 0) {
                cprod = 1;
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

        System.out.println(maxProduct(arr, n));
    }
}
