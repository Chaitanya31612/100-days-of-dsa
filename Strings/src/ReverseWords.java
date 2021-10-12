import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String S) {
        Stack<String> stack = new Stack<>();

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != '.') {
                str.append(S.charAt(i));
            } else {
                stack.push(str.toString());
                str.setLength(0);
            }
        }

        stack.push(str.toString());
        str.setLength(0);
        while(!stack.isEmpty()) {
            str.append(stack.pop());
            if(!stack.isEmpty())
                str.append('.');
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(reverseWords(s));
    }
}
