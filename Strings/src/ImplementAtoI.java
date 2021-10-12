import java.util.Scanner;

public class ImplementAtoI {

    public static int atoi(String str) {
        int num = 0, neg = 1;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == 45) {
                neg = -1;
            }
            else if(ch >= 48 && ch <= 57) {
                num = num * 10 + (ch - 48);
            } else {
                return -1;
            }
        }
        return neg * num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(atoi(str));
    }
}
