import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static boolean isAnagram(String a,String b) {
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        Arrays.sort(A);
        Arrays.sort(B);

        System.out.println(A);
        System.out.println(B);
        return String.valueOf(A).equals(String.valueOf(B));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(isAnagram(a, b));
    }
}
