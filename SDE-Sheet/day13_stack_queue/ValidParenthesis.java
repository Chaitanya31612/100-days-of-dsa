package day13_stack_queue;

import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for(int i = 0; i < s.length(); i++) {
            // enter into stack opening brackets
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // stack is not empty and top value of map corresponds to opening and closing brackets
            else if(!stack.isEmpty() && map.get(stack.peek()) == s.charAt(i)) {
                stack.pop();
            }
            // return false otherwise
            else {
                return false;
            }
        }

        if(!stack.isEmpty()) return false;
        return true;
    }
}
