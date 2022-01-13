import java.util.Scanner;
import java.util.Stack;

public class PrintSubSumK {

    // function for printing all subsequences with given sum
    public static void printSubSum(int ind, Stack<Integer> stack, int cursum, int sum, int[] arr) {
        if(ind == arr.length) {
            if(cursum == sum)
                System.out.println(stack);
            return;
        }

        cursum += arr[ind];
        stack.push(arr[ind]);
        printSubSum(ind+1, stack, cursum, sum, arr);

        cursum -= arr[ind];
        stack.pop();
        printSubSum(ind+1, stack, cursum, sum, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        printSubSum(0, new Stack<>(), 0, k, arr);
    }
}
