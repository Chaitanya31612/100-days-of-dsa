import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubarrayK {

    public static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> list =  new ArrayList<>();

        for(int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < k; j++) {
                max = Math.max(max, arr[i + j]);
            }
            list.add(max);
        }

        return list;
    }

    /*https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1/ */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(max_of_subarrays(arr, n, k));
    }

}
