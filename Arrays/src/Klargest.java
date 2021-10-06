import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Klargest {

    // initial approach - nlogn
    public static int[] kLargestInitial(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int[] ans = new int[k];
        int c = 0;
        for(int i = n - 1; i >= (n - k); i--) {
            ans[c++] = arr[i];
        }

        return ans;
    }

    // better
    public static int[] kLargestBetter(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
        }
        int[] ans = new int[k];
        int c = 0;
        while(k-- > 0) {
            ans[c++] = minHeap.remove();
        }

        return ans;
    }

    // best solution
    public static int[] kLargestBest(int[] arr, int n, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            p.add(arr[i]);
        }

        for(int i = k; i < n; i++) {
            if(!p.isEmpty() && p.peek() < arr[i]) {
                p.remove();
                p.add(arr[i]);
            }
        }

        int[] ans = new int[k];
        int c = k - 1;
        while(k-- > 0)
            ans[c--] = p.remove();

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Arrays.toString(kLargestBetter(arr, n, k)));
        System.out.println(Arrays.toString(kLargestBest(arr, n, k)));
    }
}
