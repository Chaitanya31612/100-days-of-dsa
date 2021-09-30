import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneratingParanthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        solve(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public static void solve(List<String> list, StringBuilder s, int open, int close, int n) {
        if(s.length() == 2 * n) {
            list.add(s.toString());
            return;
        }

        if(open < n) {
            s.append("(");
            solve(list, s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }
        if(close < open) {
            s.append(")");
            solve(list, s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(generateParenthesis(n));
//        StringBuilder s = new StringBuilder();
//        String str = sc.nextLine();
//        s.append(str);
//        s.deleteCharAt(s.length() - 1);
//        System.out.println(s);
//        s.setLength(s.length() - 1);
//        System.out.println(s);
    }
}
