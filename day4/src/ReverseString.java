import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while(i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        char[] str = new char[n];

        for(int i = 0; i < n; i++)
            str[i] = sc.next().charAt(0);

        reverseString(str);
        System.out.println(Arrays.toString(str));
    }
}
