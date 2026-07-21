package no_20_valid_parentheses;

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char savedBracket = stack.pop();

            if (bracket == ')' && savedBracket == '(') {
                continue;
            }
            if (bracket == '}' && savedBracket == '{') {
                continue;
            }
            if (bracket == ']' && savedBracket == '[') {
                continue;
            }

            return false;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isValid("()"));       // true
        System.out.println(solution.isValid("()[]{}"));   // true
        System.out.println(solution.isValid("(]"));       // false
        System.out.println(solution.isValid("([)]"));     // false
        System.out.println(solution.isValid("{[]}"));     // true
        System.out.println(solution.isValid("("));        // false
        System.out.println(solution.isValid("]"));        // false
    }
}