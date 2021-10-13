import java.util.Scanner;

public class MaxArray {

    public static int max(int[] arr, int idx) {
        if (idx == arr.length) {
            return Integer.MIN_VALUE;
        }

        int maxSub = max(arr, idx + 1);
        return Math.max(maxSub, arr[idx]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(max(arr, 0));
    }
}
