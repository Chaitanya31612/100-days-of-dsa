package day14_stack_queue;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        pq.add(val);
    }

    public void pop() {
        pq.remove(stack.pop());
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}
