package IsValid;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        Solution sln = new Solution();
        final String s = "(((})))";
        System.out.println(sln.isValid(s));
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            char top = stack.peek();
            if (top == '(' && s.charAt(i) == ')' ||
             top == '[' && s.charAt(i) == ']' ||
             top == '{' && s.charAt(i) == '}') {
                stack.pop();
                continue;
            }
            if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                //System.out.printf("false -> %d -> %c  %d %c==%c\n", i, s.charAt(i), stack.size(), s.charAt(i), top);
                return false;
            }
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}
