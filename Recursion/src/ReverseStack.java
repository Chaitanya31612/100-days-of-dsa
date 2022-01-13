import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    public static void reverse(Stack<Integer> stack) {
        // base condition
        if(stack.size() <= 1) return;

        int temp = stack.pop();
        reverse(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int temp) {
        // base condition
        if(stack.isEmpty()) {
            stack.push(temp);
            return;
        }
        int t = stack.pop();
        insert(stack, temp);
        stack.push(t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int n = sc.nextInt();
        for(int i = 0; i < n; i++)
            stack.push(sc.nextInt());

        reverse(stack);
        System.out.println(stack);
    }
}
