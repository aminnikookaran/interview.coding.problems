package leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class Q0020ValidParentheses {
  public boolean isValid1(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      switch (c) {
        case '(':
        case '{':
        case '[':
          stack.push(c);
          break;
        case ')':
          if (stack.isEmpty() || stack.peek() != '(') return false;
          stack.pop();
          break;
        case '}':
          if (stack.isEmpty() || stack.peek() != '{') return false;
          stack.pop();
          break;
        case ']':
          if (stack.isEmpty() || stack.peek() != '[') return false;
          stack.pop();
          break;
      }
    }
    if (stack.isEmpty()) return true;
    return false;
  }

  public boolean isValid(String s) {
    Map<Character, Character> mappings = new HashMap<Character, Character>();
    mappings.put(')', '(');
    mappings.put('}', '{');
    mappings.put(']', '[');
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (mappings.containsKey(c)) {
        char topElement = stack.empty() ? '#' : stack.pop();
        if (topElement != mappings.get(c)) return false;
      } else stack.push(c);
    }
    return stack.isEmpty();
  }
}
