package day15_strings;

import java.util.Arrays;
import java.util.Scanner;

//https://www.youtube.com/watch?v=CpZh4eF8QBw
public class ZPatternMatching {
    public int[] calculateZ(char[] input) {
        int[] Z = new int[input.length];
        int left = 0, right = 0;
        for (int i = 1; i < input.length; i++) {
            if (i > right) {
                left = right = i;
                while (right < input.length && input[right] == input[right - left]) {
                    right++;
                }
                Z[i] = right - left;
                right--;
            } else {
                int k = i - left;
                if (Z[k] < right - i + 1) {
                    Z[i] = Z[k];
                } else {
                    left = i;
                    while (right < input.length && input[right] == input[right - left]) {
                        right++;
                    }
                    Z[i] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] z = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            int k = i, j = 0;
            while(k < s.length() && s.charAt(k) == s.charAt(j)){
                k++;
                j++;
                z[i]++;
            }
        }

        System.out.println(Arrays.toString(z));
    }
}
