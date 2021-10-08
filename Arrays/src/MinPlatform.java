import java.util.ArrayList;
import java.util.Scanner;

public class MinPlatform {

    static int findPlatform(int arr[], int dep[], int n) {
        ArrayList<Integer> platform = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    temp = dep[j];
                    dep[j] = dep[j + 1];
                    dep[j + 1] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(platform.isEmpty()) {
                platform.add(dep[i]);
            }
            else {
                boolean flag = false;
                for(int j = 0; j < platform.size(); j++) {
                    if(arr[i] > platform.get(j)) {
                        platform.set(j, dep[i]);
                        flag = true;
                        break;
                    }
                }
                if(!flag) {
                    platform.add(dep[i]);
                }
            }
        }

        return platform.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dep = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i < n; i++)
            dep[i] = sc.nextInt();

        System.out.println(findPlatform(arr, dep, n));
    }
}
