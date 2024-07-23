/* 
20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isRight(s.charAt(i))) {
                if (getPair(s.charAt(i)) == stack.peek()) {
                    stack.pop();
                    continue;
                };
            } 
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    private boolean isRight(char right) {
        return right == ')' || right == '}' || right == ']';
    }

    private char getPair(char right) {
        switch (right) {
            case ')':
                return '(';
            case '}':
                return '{';
            case ']':
                return '[';
            default:
                return ' ';
        }
    }
}