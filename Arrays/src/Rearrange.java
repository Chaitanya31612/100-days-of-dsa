import java.util.Scanner;

public class Rearrange {
    // bad approach
    public static void arrangeBad(long arr[], int n) {
        long[] ans = new long[n];

        for(int i = 0; i < n; i++) {
            ans[i] = arr[(int)arr[i]];
        }

        for(int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }

    // optimal solution

    /*
    * change using the formula dividend = divisor * quotient + remainder
    * divisor = size of the array (greater than value in the array)
    * quotient = new value in the array which needs to be placed
    * remainder = old value that needs to be replaced
    * */
    public static void arrange(long[] arr, int n) {

        for(int i = 0; i < n; i++) {
            // here I am adding the old value so % will give old value, whereas / operator give the new value
            arr[i] += (arr[(int)arr[i]] % n) * n;
        }

//        for(long e : arr)
//            System.out.println(e + " " + e / n + " " + e % n);
    }

    // rearrange array with O(1) extra space
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextLong();

        arrange(arr, n);
    }
}
