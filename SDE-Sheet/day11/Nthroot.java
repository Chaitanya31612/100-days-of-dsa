package day11;

import java.util.Scanner;

public class Nthroot {
    public static double multiply(double mid, int n) {
        double mult = 1.0;
        for(int i = 1; i <= n; i++) {
            mult *= mid;
        }
        return mult;
    }

    public static void findNthRoot(int n, int m) {
        // so over here we will find the nth root of the number m

        double low = 1, high = m;
        double eps = 1e-6; // eps stands for epsilon and denotes the number of decimal places
        while((high-low) > eps) {
            double mid = (low + high) / 2.0;
            if(multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(low);
        System.out.println(high);
        System.out.println(Math.pow(m, 1.0/n));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        findNthRoot(n, m);
    }
}
