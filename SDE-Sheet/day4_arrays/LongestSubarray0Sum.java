package day4_arrays;

import java.util.*;

public class LongestSubarray0Sum {

    int maxLen(int arr[], int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // this is used for adding one to the max value as we found a zero
        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) // this is based on a logic that if we found the same sum again that means that
                                      // elements between them sums to 0
                max = Math.max(max, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return max;

    }

    public static void main(String[] args) {

    }
}
