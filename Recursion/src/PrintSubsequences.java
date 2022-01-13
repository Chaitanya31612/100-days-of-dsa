import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PrintSubsequences {

    public static void printSubsequences(int ind, Stack<Integer> list, int[] arr) {
        // base case
        if(ind == arr.length) {
            System.out.println(list);
            return;
        }

        list.push(arr[ind]);
        printSubsequences(ind + 1, list, arr);

        list.pop();
        printSubsequences(ind + 1, list, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        printSubsequences(0, new Stack<>(), arr);
    }
}
