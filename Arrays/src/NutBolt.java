import java.util.Arrays;
import java.util.Scanner;

public class NutBolt {
    public static void matchPairs(char[] nuts, char[] bolts, int n) {
        Arrays.sort(nuts);
        Arrays.sort(bolts);

        for(int i = 0; i < n; i++) {
            if(nuts[i] != bolts[i]) {
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(nuts[i] + " ");
        }

        System.out.println();
        for(int i = 0; i < n; i++) {
            System.out.print(bolts[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        char[] nuts = new char[n];
        char[] bolts = new char[n];
        for(int i = 0; i < n; i++)
            nuts[i] = sc.next().charAt(0);

        for(int i = 0; i < n; i++)
            bolts[i] = sc.next().charAt(0);

        matchPairs(nuts, bolts, n);
    }
}
