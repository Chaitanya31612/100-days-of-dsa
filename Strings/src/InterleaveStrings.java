import java.util.Scanner;

public class InterleaveStrings {

    public static boolean isInterLeave(String a,String b,String c) {
        if(a.length() + b.length() != c.length())
            return false;


        if(a.length() != 0 && a.charAt(0) == c.charAt(0)) {
            return isInterLeave(a.substring(1), b, c.substring(1));
        } else if (b.length() != 0 && b.charAt(0) == c.charAt(0)) {
            return isInterLeave(a, b.substring(1), c.substring(1));
        } else if(a.length() == 0 && b.length() == 0 && c.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();

        System.out.println(isInterLeave(a, b, c));
    }
}
