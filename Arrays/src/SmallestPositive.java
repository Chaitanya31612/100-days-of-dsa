import java.util.*;

public class SmallestPositive {

    // initial - hashset
    public static int missingNumberhashSet(int arr[], int size) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < size; i++)
            set.add(arr[i]);

        int i = 1;
        while(true) {
            if(set.contains(i)) {
                i++;
            } else {
                break;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(missingNumberhashSet(arr, n));
    }
}
