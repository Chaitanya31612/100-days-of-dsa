import java.util.Scanner;

public class MaxIndex {
    // initial - n2
    public static int maxIndexDiffinitial(int[] arr, int n) {
        int i = 0, j = n - 1;

        int maxInd = Integer.MIN_VALUE;
        for(;i <= j; i++) {
            int currInd;
            for(; j >= i; j--) {
                if(arr[j] >= arr[i]) {
                    currInd = j - i;
                    maxInd = Math.max(maxInd, currInd);
                }
            }
            j = n - 1;
        }
        return maxInd;
    }

    public static int maxIndexDiff(int[] arr, int n) {
        int i = 0, j = n - 1, max = Integer.MIN_VALUE;
        while(j >= i) {
            if(arr[j] >= arr[i]) {
                int diff = j - i;
                max = Math.max(max, diff);
                i++;
                j = n - 1;
            } else {
                j--;
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

        System.out.println(maxIndexDiff(arr, n));
    }
}
