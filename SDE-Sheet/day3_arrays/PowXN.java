package day3_arrays;

import java.util.*;

public class PowXN {

  public static double pow(double x, int n) {
    if (n == 0)
      return 1;

    double mult = pow(x, n / 2);
    mult = mult * mult;

    if ((n & 1) == 1)
      mult *= x;

    return mult;
  }

  public static double myPow(double x, int n) {
    double ans = 1.0;
    long nn = n;
    if (n < 0)
      nn = -1 * nn;

    while (nn > 0) {

      if ((nn & 1) == 1) {
        ans = ans * x;
        nn--;
      } else {
        x = x * x;
        nn = nn / 2;
      }
    }

    if (n < 0)
      ans = (double) (1.0) / (double) (ans);

    return ans;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double x = sc.nextDouble();
    int n = sc.nextInt();

    System.out.println(pow(x, n));
  }
}
