import java.util.*;

public class ReverseArray {
    public static void reverseIt(int[] arr) {
        int i = 0, j = arr.length - 1;

        while (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            i++;
            j--;
        }

    }

    public static void reverseRec(int[] arr, int i, int j) {
        if (i < j) {
            arr[i] ^= arr[j];
            arr[j] ^= arr[i];
            arr[i] ^= arr[j];
            reverseRec(arr, i + 1, j - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        reverseIt(arr);
        System.out.println(Arrays.toString(arr));
        reverseRec(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}