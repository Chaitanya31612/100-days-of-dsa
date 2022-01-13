
public class Recursion {
    public static void f(int i, int n) {
        if (i > n)
            return;

        f(i + 1, n);
        System.out.println(i);
    }

    public static int sum(int n) {
        if (n == 0)
            return 0;

        return n + sum(n - 1);
    }

    public static void fun(Integer var) {
        var = 1;
    }

    public static void main(String[] args) {
         f(1, 5);

         System.out.println(sum(3));

        Integer var = 4;
        fun(var);
        System.out.println(var);
    }
}