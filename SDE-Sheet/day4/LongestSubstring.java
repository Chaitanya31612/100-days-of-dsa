package day4;

import java.util.HashSet;
import java.util.Scanner;

public class LongestSubstring {
    // DON'T WORK
    public int lengthOfLongestSubstringBrute(String s) {
        if(s.length() == 0) return 0;
        int max = 1;

        HashSet<String> set = new HashSet<>();
        int i = 0;
        while(i < s.length()) {
            if(i == 0)
                set.add(s.substring(0, 1));
            else if(!set.contains(s.substring(i,i+1))) {
                set.add(s.substring(i,i+1));
                max = Math.max(max, set.size());
            } else {
                set.clear();
            }
            int el = s.charAt(i);
            while(i < s.length() && s.charAt(i) == el) i++;
        }

        return max;
    }

    public int lengthOfLongest(String s) {
        if(s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0, max = 1;

        while(left <= right && right < s.length()) {
            if(!set.contains((s.charAt(right)))) {
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();

        LongestSubstring l = new LongestSubstring();
//        System.out.println(l.lengthOfLongestSubstringBrute(s));
        System.out.println(l.lengthOfLongest(s));
    }
}
