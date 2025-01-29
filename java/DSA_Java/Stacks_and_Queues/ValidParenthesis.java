package DSA_Java.Stacks_and_Queues;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {
    private static boolean isValid(String s) {
     
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();

        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c); // Push opening brackets onto the stack
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false; // Invalid if no matching opening bracket
                }
            }
        }
        return stack.isEmpty(); // Valid if stack is empty at the end
    }

    public static void main(String[] args) {
        String s = "()";

        System.out.println(isValid(s)); // Output: true
    }
}
