package day4_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

//https://leetcode.com/problems/longest-consecutive-sequence/discuss/1538329/Java-easy-linear-time-solution-with-explanation-oror-TreeSet-and-HashSet-approaches

/*
* Explanation was great, loved it!!
Another better linear time approach would be to use TreeSet in java instead of HashSet, one added advantage of using treeset is that we get rid of duplicate elements as well as get our array sorted, in which we can linearly iterate to find the longest consecutive sequence.
Here is my solution on leetcode, https://leetcode.com/problems/longest-consecutive-sequence/discuss/1538329/Java-easy-linear-time-solution-with-explanation-oror-TreeSet-and-HashSet-approaches
Do check out!!
* */
public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
        }
        System.out.println(set);

        int max = 1, prev = 0, count = 1;
        for(int el: set) {
            prev = el;
            break;
        }
        for(int el: set) {
            if(el - prev == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            prev = el;
        }
        return max;
    }

    public int longestConsecutiveSet(int[] nums) {
        if(nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums)
            set.add(num);

        int max = 1;
        for(int el: set) {
            if(!set.contains(el-1)) {
                int c = el+1, cnt = 1;
                while(set.contains(c)) {
                    c++;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public int longestConsecutiveSorting(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        int max = Integer.MIN_VALUE, prev = nums[0], count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - prev == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            prev = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        LongestConsecutiveSubsequence l = new LongestConsecutiveSubsequence();
//        System.out.println(l.longestConsecutiveSorting(nums));
        System.out.println(l.longestConsecutive(nums));
        System.out.println(l.longestConsecutiveSet(nums));
    }
}
