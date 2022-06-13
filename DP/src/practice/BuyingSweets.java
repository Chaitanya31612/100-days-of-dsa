package practice;

import java.util.Arrays;
import java.util.Scanner;

public class BuyingSweets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int N = sc.nextInt();
            int R = sc.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++)
                A[i] = sc.nextInt();

            int[] B = new int[N];
            for (int i = 0; i < N; i++)
                B[i] = sc.nextInt();

            int sweets = 0;

            int[][] arr = new int[N][2];
            for(int i = 0; i < N; i++) {
                arr[i][0] = A[i];
                arr[i][1] = B[i]-A[i];
            }

            Arrays.sort(arr, (a, b) -> b[1] - a[1]);

            while(R > 0) {
                int i = 0;
                while(i < N && arr[i][0] > R) i++;
                if(i == N) break;
                if(arr[i][0] <= R) {
                    int s = (R/Math.abs(arr[i][1])) - (arr[i][0] - 1)/Math.abs(arr[i][1]);
                    R = R - s * Math.abs(arr[i][1]);
                    sweets += s;
                }
            }
            System.out.println(sweets);
        }
    }
}
