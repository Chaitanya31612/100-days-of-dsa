package day12;

public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
        int c = 0;
        while(n > 0) {
            c += n & 1;
            n = n >> 1;
        }

        if(c == 1) return true;

        return false;
    }

    public boolean isPowerOfTwoFn(int n) {
        return (n > 0) && (Integer.bitCount(n) == 1);
    }

    public static void main(String[] args) {

    }
}
