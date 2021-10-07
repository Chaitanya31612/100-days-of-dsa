import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MinSwaps {

    // idea is to first sort the list (value with index) then count number of swaps that are required to bring it back to normal
    static class Pair {
        int value;
        int index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        ArrayList<Pair> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Pair(arr[i], i));
        }
        // comparator for sorting the array in ascending order
        Comparator<Pair> c = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        };

        Collections.sort(list, c);

        // count is the number of swaps required
        int count = 0;
        // then traverse the list and check whether index after sorting is equal to initial index, if not then swap it
        for(int i = 0; i < n; i++) {
            if(list.get(i).index == i)
                continue;

            Collections.swap(list, i, list.get(i).index);
            count++;
            i--; // to again check until the index becomes equal to i
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(minSwaps(nums));
    }
}
