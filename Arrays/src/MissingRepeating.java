import java.util.Arrays;
import java.util.Scanner;

public class MissingRepeating {
    static int[] findTwoElement(int arr[], int n) {
        int missing = 0, repeat = -1;
        long sum = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                if(arr[(-1) * arr[i] - 1] < 0) {
//                    repeat = -1 * arr[(-1) * arr[i] - 1];
                    continue;
                }
                arr[(-1) * arr[i] - 1] *= -1;
            } else {
                if(arr[arr[i] - 1] < 0) {
//                    repeat = arr[arr[i] - 1];
                    continue;
                }
                arr[arr[i] - 1] *= -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        for(int i = 0; i < n; i++)
            sum += Math.abs(arr[i]);
        sum += missing;

//        System.out.println(sum);

        long total = (long)n * (n + 1) / 2;
//        System.out.println(total);
        repeat = (int)Math.abs(sum - total);

        return new int[]{repeat, missing};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(Arrays.toString(findTwoElement(arr, n)));
    }
}
