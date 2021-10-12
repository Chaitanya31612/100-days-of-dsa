import java.util.Scanner;

public class RunLengthEncoding {

    public static String encode(String s) {
        if(s.length() == 0)
            return s;
        char ch = s.charAt(0);
        int count = 1;

        StringBuilder str = new StringBuilder();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ch) {
                count++;
            } else {
                str.append(ch);
                str.append(count);
                ch = s.charAt(i);
                count = 1;
            }
        }

        str.append(ch);
        str.append(count);

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(encode(s));
    }
}
