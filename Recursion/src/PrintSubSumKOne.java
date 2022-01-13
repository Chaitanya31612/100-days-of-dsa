import java.util.Scanner;
import java.util.Stack;

public class PrintSubSumKOne {

    // function for printing all subsequences with given sum
    public static boolean printSubSum(int ind, Stack<Integer> stack, int cursum, int sum, int[] arr) {
        if(ind == arr.length) {
            if(cursum == sum) {
                System.out.println(stack);
                return true;
            }
            return false;
        }

        cursum += arr[ind];
        stack.push(arr[ind]);
        if(printSubSum(ind+1, stack, cursum, sum, arr)) {
            return true;
        }

        cursum -= arr[ind];
        stack.pop();
        if(printSubSum(ind+1, stack, cursum, sum, arr)) return true;

        return false;
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
