import java.math.BigInteger;
import java.util.Scanner;

public class MutiplyStrings {

    // this approach can work for small numbers
    public static String multiplyStringsSmall(String s1,String s2) {
        long first = Long.parseLong(s1);
        long second = Long.parseLong(s2);

        return String.valueOf(first * second);
    }

    public static String multiplyStrings(String s1,String s2) {
        BigInteger a = new BigInteger(s1);
        BigInteger b  = new BigInteger(s2);

        return a.multiply(b).toString();
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(multiplyStrings(s1, s2));
    }
}
