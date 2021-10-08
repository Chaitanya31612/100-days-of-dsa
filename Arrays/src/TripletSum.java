import java.util.HashMap;
import java.util.Scanner;

public class TripletSum {

    public static boolean find3Numbers(int A[], int n, int X) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(!map.containsKey(A[i])) {
                map.put(A[i], 0);
            }
            map.put(A[i], map.get(A[i]) + 1);
        }

        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i + 1; j < n; j++) {
                sum = A[i] + A[j];
                if(sum >= X) {
                    continue;
                }
                map.put(A[i], map.get(A[i]) - 1);
                map.put(A[j], map.get(A[j]) - 1);
                int left = X - sum;
                if(map.containsKey(left)) {
                    return map.get(left) > 0;
                }
                map.put(A[i], map.get(A[i]) + 1);
                map.put(A[j], map.get(A[j]) + 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(find3Numbers(arr, n, x));
    }
}
