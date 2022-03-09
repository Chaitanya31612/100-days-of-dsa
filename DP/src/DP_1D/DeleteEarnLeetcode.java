package DP_1D;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteEarnLeetcode {
    static private HashMap<Integer, Integer> points = new HashMap<>();
    static private HashMap<Integer, Integer> cache = new HashMap<>();

    private static int maxPoints(int num) {
        // Check for base cases
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        if (cache.containsKey(num)) {
            return cache.get(num);
        }

        // Apply recurrence relation
        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }

    public static int deleteAndEarn(int[] nums) {
        int maxNumber = 0;

        // Precompute how many points we gain from taking an element
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

        System.out.println(points + " " + maxNumber);
        return maxPoints(maxNumber);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(deleteAndEarn(nums));
    }
}