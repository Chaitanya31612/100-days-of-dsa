package day13;

import java.util.LinkedList;
import java.util.Queue;

public class StackUse {
    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.print();

        System.out.println(stack.pop());

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println();

        stack.pop();

        Queue<Integer> queue = new LinkedList<>();
        
    }
}
