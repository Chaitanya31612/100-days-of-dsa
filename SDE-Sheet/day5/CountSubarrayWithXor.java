package day5;

// https://www.youtube.com/watch?v=lO9R5CaGRPY&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=26

import java.util.HashMap;

public class CountSubarrayWithXor {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int cnt = 0;
        int xorr = 0;

        int n = A.length;

        for(int i = 0;i<n;i++) {
            xorr = xorr ^ A[i];
            if(freq.get(xorr^B) != null)
                cnt += freq.get(xorr ^ B);
            if(xorr == B) {
                cnt++;
            }

            if(freq.get(xorr) != null)
                freq.put(xorr, freq.get(xorr) + 1);
            else
                freq.put(xorr, 1);
        }
        return cnt;
    }
    public static void main(String[] args) {

    }
}
