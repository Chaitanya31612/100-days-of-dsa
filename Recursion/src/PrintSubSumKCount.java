import java.util.Scanner;
import java.util.Stack;

public class PrintSubSumKCount {

    // function for printing all subsequences with given sum
    public static int printSubSum(int ind, int cursum, int sum, int[] arr) {
        if(ind == arr.length) {
            if(cursum == sum) return 1;
            else return 0;
        }

        cursum += arr[ind];
        int taking = printSubSum(ind+1, cursum, sum, arr);

        cursum -= arr[ind];
        int not_taking = printSubSum(ind+1, cursum, sum, arr);

        return taking + not_taking;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        int ans = printSubSum(0, 0, k, arr);
        System.out.println(ans);
    }
}
