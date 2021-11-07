package day4;

import java.util.Scanner;
import java.util.TreeSet;

public class LongestSubsequence {
    public int lengthOfLongestSubsequence(String s) {
        if(s.length() == 0) return 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            set.add(ch);
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        LongestSubsequence l = new LongestSubsequence();
        System.out.println(l.lengthOfLongestSubsequence(str));
    }
}
