import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SortStack {
    public static void sort(Stack<Integer> stack) {
        if(stack.size() <= 1) return;

        int temp = stack.pop();
        sort(stack);
        insert(stack, temp);
    }

    public static void insert(Stack<Integer> stack, int temp) {
        if(stack.size() == 0 || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        int t = stack.pop();
        insert(stack, temp);
        stack.push(t);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
            stack.push(sc.nextInt());

        sort(stack);
        System.out.println(stack);
    }
}
