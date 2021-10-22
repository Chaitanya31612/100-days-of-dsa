package day3;

import java.math.BigInteger;
import java.util.*;

// https://leetcode.com/problems/reverse-pairs/

public class ReversePair {
    public static int reversePair(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int s, int e) {
        int count = 0;
        if (s < e) {
            int mid = (s + e) / 2;
            count += mergeSort(nums, s, mid);
            count += mergeSort(nums, mid + 1, e);
            count += merge(nums, s, mid, e);
        }
        return count;
    }

    public static int merge(int[] nums, int s, int mid, int e) {

        int count = 0;
        int j = mid + 1;
        for (int i = s; i <= mid; i++) {
            while (j <= e && nums[i] > (long) 2 * nums[j]) {
                j++;
            }
            count += j - (mid + 1); // excluding jth number
        }

        int[] temp = new int[e - s + 1];
        int i = s, k = 0;
        j = mid + 1;
        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid)
            temp[k++] = nums[i++];

        while (j <= e)
            temp[k++] = nums[j++];

        for (int t = 0; t < temp.length; t++)
            nums[s + t] = temp[t];

        return count;
    }

    public static int reversePairBrute(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long val = (long) 2 * nums[j];
                if (nums[j] != Integer.MAX_VALUE && nums[j] != Integer.MIN_VALUE && nums[i] > val) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(reversePair(nums));
    }
}
