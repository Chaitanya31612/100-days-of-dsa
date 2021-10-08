import java.util.Arrays;
import java.util.Scanner;

public class RearrangeAlt {

    public static void rearrange(int arr[], int n){
        int s = 0, e = n - 1;
        int c = 0;

        if(n == 1) {
            return;
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        max++;

        while(s < e) {
            arr[c++] += (arr[e--] % max) * max;
            arr[c++] += (arr[s++] % max) * max;
        }

        if(s == e) {
            arr[c] += (arr[s] % max) * max;
        }

        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < n; i++) {

            arr[i] = (arr[i] / max);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        rearrange(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}
