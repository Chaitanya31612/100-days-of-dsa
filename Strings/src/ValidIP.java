import java.util.Scanner;

public class ValidIP {

    public static boolean isValid(String s) {
        if(s.length() < 7 || s.length() > 15)
            return false;

        int num = 0, len = 0, period = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '.') {
                if((len != (String.valueOf(num).length())) || len > 3 || num > 255)
                    return false;
                period++;
                num = 0;
                len = 0;
            } else if(ch >= 48 && ch <= 57) {
                num = num * 10 + (ch - 48);
                len++;
            } else {
                return false;
            }
        }

        if((len != (String.valueOf(num).length()))|| period != 3)
            return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(isValid(s));
    }
}
