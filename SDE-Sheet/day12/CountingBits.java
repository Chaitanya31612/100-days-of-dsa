package day12;

public class CountingBits {
    public int[] countBitsBest(int n) {
        int[] ans = new int[n+1];

        for(int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        ans[0] = 0;
        for(int i = 1; i <= n; i++) {
//            ans[i] = Integer.bitCount(i);
            ans[i] = cntBits(i);
        }

        return ans;
    }

     public int cntBits(int n) {
         int cnt = 0;
         while(n > 0) {
             cnt += (n & 1);
             n = n >> 1;
         }

         return cnt;
     }
}
