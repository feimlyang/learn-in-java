/*
1047. Remove All Adjacent Duplicates In String

You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

*/

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (s.charAt(i) == stack.peek()) {
                    stack.pop();
                    continue;
                };
            }
            stack.push(s.charAt(i));
        }

        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }

        return res;
    }
}