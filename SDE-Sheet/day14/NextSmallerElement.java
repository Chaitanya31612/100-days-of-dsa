package day14;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        int[] arr = new int[A.size()];
        ArrayList<Integer> G = new ArrayList<>();
        for(int i = 0; i < A.size(); i++)
            arr[i] = -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = A.size() - 1; i >= 0; i--) {
            while(!stack.isEmpty() && A.get(i) < A.get(stack.peek())) {
                arr[stack.peek()] = A.get(i);
                stack.pop();
            }
            stack.push(i);
        }

        for(int i = 0; i < A.size(); i++) {
            G.add(arr[i]);
        }

        return G;
    }

    public static void main(String[] args) {

    }
}
